package com.runapp.achievementservice.service.goalChecker;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatistic;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionPercentageCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class TotalTrainingTimeStrategyUpdate implements UpdateGoalStrategy {

    private final GoalRepository goalRepository;
    private final UserStatisticRepository achievementRepository;

    public TotalTrainingTimeStrategyUpdate(GoalRepository goalRepository, UserStatisticRepository achievementRepository) {
        this.goalRepository = goalRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void updateGoal(GoalModel model, List<TrainingModel> allTraining) {
        UserStatistic userProgress = achievementRepository.findById(model.getUserId()).orElse(new UserStatistic());

        Duration sumDurationAllTraining = userProgress.getTotalAmountOfTrainingTime();
        Duration currentGoalDuration = Duration.parse(model.getGoal());

        if (sumDurationAllTraining.compareTo(currentGoalDuration) >= 0) {
            goalRepository.save(GoalMark.finishGoal(model));
        } else {
            model.setCompletionPercentage(
                    GoalCompletionPercentageCalculator.calculatePercentage(sumDurationAllTraining, currentGoalDuration)
            );
            goalRepository.save(model);
        }
    }
}

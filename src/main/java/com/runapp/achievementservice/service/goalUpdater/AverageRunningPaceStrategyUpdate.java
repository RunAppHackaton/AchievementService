package com.runapp.achievementservice.service.goalUpdater;

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
public class AverageRunningPaceStrategyUpdate implements UpdateGoalStrategy {

    private final GoalRepository goalRepository;
    private final UserStatisticRepository achievementRepository;

    public AverageRunningPaceStrategyUpdate(GoalRepository goalRepository, UserStatisticRepository achievementRepository) {
        this.goalRepository = goalRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void updateGoal(GoalModel model, List<TrainingModel> allTraining) {
        UserStatistic userProgress = achievementRepository.findById(model.getUserId()).orElse(new UserStatistic());

        Duration currentAveragePace = userProgress.getAveragePaceRecord();
        Duration goalAveragePace = Duration.parse(model.getGoal());

        if (currentAveragePace.compareTo(goalAveragePace) < 0) {
            goalRepository.save(GoalMark.finishGoal(model));
        } else {
            model.setCompletionPercentage(
                    GoalCompletionPercentageCalculator.calculatePercentage(currentAveragePace, goalAveragePace)
            );
            goalRepository.save(model);
        }
    }
}

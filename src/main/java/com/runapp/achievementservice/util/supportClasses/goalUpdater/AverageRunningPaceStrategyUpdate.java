package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionCalculator;
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
        UserStatisticModel userProgress = achievementRepository.findById(model.getUserId()).orElse(new UserStatisticModel());

        Duration currentAveragePace = userProgress.getAveragePaceRecord();
        Duration goalAveragePace = Duration.parse(model.getGoal());

        if (currentAveragePace.compareTo(goalAveragePace) < 0) {
            goalRepository.save(GoalMark.finishGoal(model));
        } else {
            model.setCompletionPercentage(
                    (float) GoalCompletionCalculator.calculatePercentage(currentAveragePace, goalAveragePace)
            );
            goalRepository.save(model);
        }
    }
}

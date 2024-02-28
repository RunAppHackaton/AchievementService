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
import java.util.Optional;

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
        Optional<UserStatisticModel> optionalUserProgress = achievementRepository.findById(model.getUserId());
        if (optionalUserProgress.isPresent()) {
            UserStatisticModel userProgress = optionalUserProgress.get();

            Duration currentAveragePace = userProgress.getAveragePaceRecord();
            Duration goalAveragePace = Duration.parse(model.getGoal());

            if (currentAveragePace != null) {
                double completionPercentage = GoalCompletionCalculator.calculatePercentage(currentAveragePace, goalAveragePace);
                model.setCompletionPercentage((float) completionPercentage);

                if (completionPercentage < 100) {
                    goalRepository.save(model);
                } else {
                    goalRepository.save(GoalMark.finishGoal(model));
                }
            } else {
                // User progress not found or null, save the goal without completion percentage
                goalRepository.save(model);
            }
        } else {
            // User progress not found, save the goal without completion percentage
            goalRepository.save(model);
        }
    }
}

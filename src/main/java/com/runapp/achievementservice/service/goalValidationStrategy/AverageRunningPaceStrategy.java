package com.runapp.achievementservice.service.goalValidationStrategy;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserProgressInAchievementModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserProgressInAchievementRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionPercentageCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class AverageRunningPaceStrategy implements GoalStrategy {

    private final GoalRepository goalRepository;
    private final UserProgressInAchievementRepository achievementRepository;

    public AverageRunningPaceStrategy(GoalRepository goalRepository, UserProgressInAchievementRepository achievementRepository) {
        this.goalRepository = goalRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void execute(GoalModel model, List<TrainingModel> allTraining) {
        UserProgressInAchievementModel userProgress = achievementRepository.findById(model.getUserId()).orElse(new UserProgressInAchievementModel());

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

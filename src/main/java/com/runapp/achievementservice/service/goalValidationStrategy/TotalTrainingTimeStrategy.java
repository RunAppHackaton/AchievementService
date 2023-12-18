package com.runapp.achievementservice.service.goalValidationStrategy;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserProgressInAchievementRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionPercentageCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
@AllArgsConstructor
public class TotalTrainingTimeStrategy implements GoalStrategy {

    private final GoalRepository goalRepository;

    @Override
    public void execute(GoalModel model, List<TrainingModel> allTraining) {
        Duration sumDurationAllTraining = allTraining.stream()
                .map(TrainingModel::getDuration)
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);

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

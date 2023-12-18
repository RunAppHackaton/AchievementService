package com.runapp.achievementservice.service.goalValidationStrategy;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionPercentageCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
@AllArgsConstructor
public class AverageRunningPaceStrategy implements GoalStrategy {

    private final GoalRepository goalRepository;
    private final TrainingRepository trainingRepository;

    @Override
    public void execute(GoalModel model, List<TrainingModel> allTraining) {
        Duration currentAveragePace = trainingRepository.findTrainingWithMinAveragePace().getAveragePace();
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

package com.runapp.achievementservice.service.goalValidationStrategy;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.util.goalHandler.GoalHandler;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionPercentageCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TotalNumberTrainingStrategy implements GoalStrategy {

    private final GoalRepository goalRepository;

    @Override
    public void execute(GoalModel model, List<TrainingModel> allTraining) {
        int currentCountTrainings = allTraining.size();
        int goalCountTrainings = Integer.parseInt(model.getGoal());

        if (currentCountTrainings >= goalCountTrainings) {
            goalRepository.save(GoalMark.finishGoal(model));
        } else {
            model.setCompletionPercentage(
                    GoalCompletionPercentageCalculator
                            .calculatePercentage(currentCountTrainings, goalCountTrainings)
            );
            goalRepository.save(model);
        }
    }
}

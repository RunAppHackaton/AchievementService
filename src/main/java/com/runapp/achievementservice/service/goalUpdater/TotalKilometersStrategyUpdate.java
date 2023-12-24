package com.runapp.achievementservice.service.goalUpdater;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotalKilometersStrategyUpdate implements UpdateGoalStrategy {

    private final GoalRepository goalRepository;

    public TotalKilometersStrategyUpdate(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public void updateGoal(GoalModel model, List<TrainingModel> allTraining) {
        int currentKilometers = allTraining.stream()
                .mapToInt(TrainingModel::getDistanceKm)
                .sum();

        int goalKilometers = Integer.parseInt(model.getGoal());

        if (currentKilometers >= goalKilometers) {
            goalRepository.save(GoalMark.finishGoal(model));
        } else {
            model.setCompletionPercentage(
                    GoalCompletionCalculator
                            .calculatePercentage(currentKilometers, goalKilometers)
            );
            goalRepository.save(model);
        }
    }
}

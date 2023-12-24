package com.runapp.achievementservice.util.supportClasses.goalUpdater;

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
        int currentKilometers = calculateCurrentKilometers(allTraining);
        int goalKilometers = Integer.parseInt(model.getGoal());

        if (currentKilometers >= goalKilometers) {
            GoalMark.finishGoal(model);
        } else {
            model.setCompletionPercentage(GoalCompletionCalculator.calculatePercentage(currentKilometers, goalKilometers));
        }
        goalRepository.save(model);
    }

    private int calculateCurrentKilometers(List<TrainingModel> allTraining) {
        return allTraining.stream()
                .mapToInt(TrainingModel::getDistanceKm)
                .sum();
    }
}

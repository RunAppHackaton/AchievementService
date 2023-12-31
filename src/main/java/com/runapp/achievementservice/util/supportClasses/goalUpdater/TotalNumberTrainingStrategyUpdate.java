package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotalNumberTrainingStrategyUpdate implements UpdateGoalStrategy {

    private final GoalRepository goalRepository;
    private final UserStatisticRepository achievementRepository;

    public TotalNumberTrainingStrategyUpdate(GoalRepository goalRepository, UserStatisticRepository achievementRepository) {
        this.goalRepository = goalRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void updateGoal(GoalModel model, List<TrainingModel> allTraining) {
        UserStatisticModel userProgress = achievementRepository.findById(model.getUserId()).orElse(new UserStatisticModel());

        int currentCountTrainings = Math.toIntExact(userProgress.getNumberOfTrainingSessionsOverTime());
        int goalCountTrainings = Integer.parseInt(model.getGoal());

        if (currentCountTrainings >= goalCountTrainings) {
            GoalMark.finishGoal(model);
        } else {
            model.setCompletionPercentage(GoalCompletionCalculator.calculatePercentage(currentCountTrainings, goalCountTrainings));
        }
        goalRepository.save(model);
    }
}

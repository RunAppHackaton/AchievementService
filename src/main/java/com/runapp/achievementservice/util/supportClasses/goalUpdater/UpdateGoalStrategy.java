package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;

import java.util.List;

public interface UpdateGoalStrategy {
    void updateGoal(GoalModel model, List<TrainingModel> allTraining);
}

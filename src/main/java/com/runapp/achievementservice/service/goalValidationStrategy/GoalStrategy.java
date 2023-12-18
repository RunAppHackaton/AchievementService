package com.runapp.achievementservice.service.goalValidationStrategy;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;

import java.util.List;

public interface GoalStrategy {
    void execute(GoalModel model, List<TrainingModel> allTraining);
}

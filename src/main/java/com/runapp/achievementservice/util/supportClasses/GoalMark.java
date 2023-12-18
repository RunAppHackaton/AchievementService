package com.runapp.achievementservice.util.supportClasses;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;

import java.time.LocalDateTime;

public class GoalMark {

    public static GoalModel finishGoal(GoalModel model) {
        model.setCompletionPercentage(100);
        model.setGoalStatus(new GoalStatusModel(GoalStatusEnum.FINISHED));
        model.setFinishedDate(LocalDateTime.now());
        return model;
    }
}

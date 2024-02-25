package com.runapp.achievementservice.staticObject;

import com.runapp.achievementservice.dto.request.GoalRequest;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;

public class StaticGoal {
    public static GoalModel goalModel1() {
        GoalStatusModel goalStatus2 = new GoalStatusModel();
        goalStatus2.setGoalModels(new ArrayList<>());
        goalStatus2.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType2 = new GoalTypeModel();
        goalType2.setGoalModels(new ArrayList<>());
        goalType2.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel updatedGoal = new GoalModel();
        updatedGoal.setCompletionPercentage(10.0f);
        updatedGoal.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        updatedGoal.setGoal("Goal");
        updatedGoal.setGoalStatus(goalStatus2);
        updatedGoal.setGoalType(goalType2);
        updatedGoal.setId(1L);
        updatedGoal.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        updatedGoal.setUserId(1L);
        return updatedGoal;  // Return the created GoalModel
    }


    public static GoalTypeModel goalTypeModel1(){
        GoalTypeModel goalTypeModel = new GoalTypeModel();
        goalTypeModel.setGoalModels(new ArrayList<>());
        goalTypeModel.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        return goalTypeModel;
    }

    public static GoalStatusModel goalStatusModel1(){
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        return goalStatus;
    }

    public static GoalRequest goalRequest1(){
        GoalRequest goalRequest2 = new GoalRequest();
        goalRequest2.setGoal("Goal");
        goalRequest2.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        goalRequest2.setUserId(1L);
        return goalRequest2;
    }
}

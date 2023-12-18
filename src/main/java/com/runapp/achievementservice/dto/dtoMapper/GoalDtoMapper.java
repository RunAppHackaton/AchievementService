package com.runapp.achievementservice.dto.dtoMapper;

import com.runapp.achievementservice.dto.request.GoalRequest;
import com.runapp.achievementservice.dto.response.GoalResponse;
import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.goalHandler.GoalFactoryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class GoalDtoMapper implements DtoMapper<GoalModel, GoalRequest, GoalResponse> {

    @Override
    public GoalModel toModel(GoalRequest goalRequest) {
        if (GoalFactoryHandler.isValid(goalRequest.getGoal_type(), goalRequest.getGoal())) {
            GoalModel model = new GoalModel();
            model.setUserId(goalRequest.getUserId());
            model.setGoalStatus(new GoalStatusModel(GoalStatusEnum.IN_PROGRESS));
            model.setGoalType(new GoalTypeModel(goalRequest.getGoal_type()));
            model.setStartDate(LocalDateTime.now());
            model.setGoal(goalRequest.getGoal());
            return model;
        }
        throw new NoEntityFoundException("goal_type is not valid");
    }

    @Override
    public GoalResponse toResponse(GoalModel goalModel) {
        return GoalResponse.builder()
                .id(goalModel.getId())
                .userId(goalModel.getUserId())
                .completionPercentage(goalModel.getCompletionPercentage())
                .goal_type(goalModel.getGoalType().getGoalTypeEnum())
                .goal_status(goalModel.getGoalStatus().getStatusEnum())
                .startDate(goalModel.getStartDate())
                .finishedDate(goalModel.getFinishedDate())
                .goal(goalModel.getGoal())
                .build();
    }
}

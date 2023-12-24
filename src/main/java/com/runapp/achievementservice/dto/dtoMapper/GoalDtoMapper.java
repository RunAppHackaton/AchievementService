package com.runapp.achievementservice.dto.dtoMapper;

import com.runapp.achievementservice.dto.request.GoalRequest;
import com.runapp.achievementservice.dto.response.GoalResponse;
import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.goalHandler.GoalFactoryHandler;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GoalDtoMapper implements DtoMapper<GoalModel, GoalRequest, GoalResponse> {

    private final GoalFactoryHandler goalFactoryHandler;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public GoalModel toModel(GoalRequest goalRequest) {
        if (goalFactoryHandler.isValid(goalRequest.getGoal_type(), goalRequest.getGoal())) {
            GoalModel model = new GoalModel();
            model.setUserId(goalRequest.getUserId());
            model.setGoalStatus(entityManager.find(GoalStatusModel.class, GoalStatusEnum.IN_PROGRESS));
            model.setGoalType(entityManager.find(GoalTypeModel.class, goalRequest.getGoal_type()));
            model.setStartDate(LocalDateTime.now());
            model.setGoal(goalRequest.getGoal());
            model.setCompletionPercentage(0F);
            return model;
        }
        throw new NoEntityFoundException("goal is not valid");
    }

    @Override
    public GoalResponse toResponse(GoalModel goalModel) {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setId(goalModel.getId());
        goalResponse.setUserId(goalModel.getUserId());
        goalResponse.setCompletionPercentage(goalModel.getCompletionPercentage());
        goalResponse.setGoal_type(goalModel.getGoalType().getGoalTypeEnum());
        goalResponse.setGoal_status(goalModel.getGoalStatus().getStatusEnum());
        goalResponse.setStartDate(goalModel.getStartDate());
        goalResponse.setFinishedDate(goalModel.getFinishedDate());
        goalResponse.setGoal(goalModel.getGoal());
        return goalResponse;
    }

    @Override
    public List<GoalResponse> toResponseList(List<GoalModel> goalModels) {
        return goalModels.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

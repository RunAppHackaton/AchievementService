package com.runapp.achievementservice.dto.request;

import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GoalRequest {
    private GoalTypeEnum goal_type;
    private String goal;
    private Long userId;
}

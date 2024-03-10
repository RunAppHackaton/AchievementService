package com.runapp.achievementservice.dto.request;

import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GoalRequest {
    private GoalTypeEnum goal_type;
    private String goal;
    private String userId;
}

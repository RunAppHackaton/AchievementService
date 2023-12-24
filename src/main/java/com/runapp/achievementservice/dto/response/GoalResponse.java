package com.runapp.achievementservice.dto.response;

import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class GoalResponse {
    private int id;
    private Long userId;
    private float completionPercentage;
    private GoalTypeEnum goal_type;
    private GoalStatusEnum goal_status;
    private LocalDateTime startDate;
    private LocalDateTime finishedDate;
    private String goal;
}

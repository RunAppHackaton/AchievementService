package com.runapp.achievementservice.dto.response;

import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
public class GoalResponse {
    private int id;
    private Long userId;
    private Integer completionPercentage;
    private GoalTypeEnum goal_type;
    private GoalStatusEnum goal_status;
    private LocalDateTime startDate;
    private LocalDateTime finishedDate;
    private String goal;
}

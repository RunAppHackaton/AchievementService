package com.runapp.achievementservice.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;

@Builder
@Data
public class TrainingRequest {
    private LocalDate training_date;
    private int distance_km;
    private Duration training_duration;
    private Duration pace;
    private Long userId;
}

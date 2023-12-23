package com.runapp.achievementservice.dto.response;

import lombok.Builder;

import java.time.Duration;
import java.time.LocalDate;

@Builder
public class TrainingResponse {
    private LocalDate training_date;
    private int distance_km;
    private Duration training_duration;
    private Duration pace;
    private int userId;
}

package com.runapp.achievementservice.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Component
@Data
public class TrainingResponse {
    private LocalDate training_date;
    private int distance_km;
    private Duration training_duration;
    private Duration pace;
    private Long userId;
}

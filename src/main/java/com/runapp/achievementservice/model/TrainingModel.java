package com.runapp.achievementservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Training")
public class TrainingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "training_date")
    private LocalDate dateTraining;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "training_duration_mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Duration duration;

    @Column(name = "distance_km")
    private Integer distanceKm;

    @Column(name = "average_pace_mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Duration averagePace;
}

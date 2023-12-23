package com.runapp.achievementservice.model;

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
    private Integer id;

    @Column(name = "training_date")
    private LocalDate dateTraining;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "training_duration")
    private Duration duration;

    @Column(name = "distance_km")
    private Integer distanceKm;

    @Column(name = "average_pace")
    private Duration averagePace;
}

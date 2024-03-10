package com.runapp.achievementservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Duration;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_statistic")
public class UserStatisticModel implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "number_of_workouts_per_week")
    private Long numberOfWorkoutsPerWeek;

    @Column(name = "number_of_workouts_per_month")
    private Long numberOfWorkoutsPerMonth;

    @Column(name = "number_of_trainings_per_year")
    private Long numberOfWorkoutsPerYear;

    @Column(name = "number_of_training_sessions_over_time")
    private Long numberOfTrainingSessionsOverTime;

    @Column(name = "total_number_of_workouts_for_all_time")
    private Long totalNumberOfWorkoutsForAllTime;

    @Column(name = "total_amount_of_training_time_mm")
    private Duration totalAmountOfTrainingTime;

    @Column(name = "average_pace_record_mm")
    private Duration averagePaceRecord;

}

package com.runapp.achievementservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Goal")
public class GoalModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "completion_percentage")
    private float completionPercentage;

    @Column(name = "user_id")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "goal_type_id")
    private GoalTypeModel goalType;

    @ManyToOne
    @JoinColumn(name = "goal_status_id")
    private GoalStatusModel goalStatus;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "finished_date")
    private LocalDateTime finishedDate;

    @Column(name = "goal")
    private String goal;
}

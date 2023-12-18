package com.runapp.achievementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Goal_Status")
public class GoalStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private GoalStatusEnum statusEnum;

    @JsonIgnore
    @OneToMany(mappedBy = "goalStatus")
    private List<GoalModel> goalModels;

    public GoalStatusModel(GoalStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
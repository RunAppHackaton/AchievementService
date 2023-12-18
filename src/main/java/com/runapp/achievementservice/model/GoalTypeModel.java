package com.runapp.achievementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Goal_Type")
public class GoalTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private GoalTypeEnum goalTypeEnum;

    @JsonIgnore
    @OneToMany(mappedBy = "goalType")
    private List<GoalModel> goalModels;

    public GoalTypeModel(GoalTypeEnum goalTypeEnum) {
        this.goalTypeEnum = goalTypeEnum;
    }
}

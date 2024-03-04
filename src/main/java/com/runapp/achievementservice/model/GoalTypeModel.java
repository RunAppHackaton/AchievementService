package com.runapp.achievementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "goal_type")
public class GoalTypeModel implements Serializable {

    @Id
    @Column(name = "goal_type_name")
    @Enumerated(EnumType.STRING)
    private GoalTypeEnum goalTypeEnum;

    @JsonIgnore
    @OneToMany(mappedBy = "goalType")
    private List<GoalModel> goalModels;

    public GoalTypeModel(GoalTypeEnum goalTypeEnum) {
        this.goalTypeEnum = goalTypeEnum;
    }
}

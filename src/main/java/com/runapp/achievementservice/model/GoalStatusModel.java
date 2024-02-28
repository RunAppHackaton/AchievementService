package com.runapp.achievementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "goal_status")
public class GoalStatusModel implements Serializable {

    @Id
    @Column(name = "goal_status_name")
    @Enumerated(EnumType.STRING)
    private GoalStatusEnum statusEnum;

    @JsonIgnore
    @OneToMany(mappedBy = "goalStatus")
    private List<GoalModel> goalModels;

    public GoalStatusModel(GoalStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}

package com.runapp.achievementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rarity_model")
public class RarityModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "rarityModel")
    private List<AchievementModel> achievementModelList;

    @Override
    public String toString() {
        return "RarityModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

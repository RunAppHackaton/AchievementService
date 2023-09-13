package com.runapp.achievementservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Achievement")
public class AchievementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "story_id")
    private int story_id;

    @Column(name = "description")
    private String description;

    @Column(name = "achievement_image_url")
    private String achievementImageUrl;

    @ManyToOne
    @JoinColumn(name = "rarity_id")
    private RarityModel rarityModel;
}

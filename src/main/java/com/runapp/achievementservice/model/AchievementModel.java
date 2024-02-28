package com.runapp.achievementservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "achievement")
public class AchievementModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "story_id")
    private Long story_id;

    @Column(name = "description")
    private String description;

    @Column(name = "achievement_image_url")
    private String achievementImageUrl;

    @ManyToOne
    @JoinColumn(name = "rarity_id")
    private RarityModel rarityModel;
}

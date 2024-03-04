package com.runapp.achievementservice.dto.request;

import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementRequest {
    private String name;

    private Long story_id;

    private String description;

    private Long rarity_id;

    public AchievementModel ToAchievementModel(RarityModel rarityModel) {
        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setName(this.name);
        achievementModel.setStory_id(story_id);
        achievementModel.setDescription(this.description);
        achievementModel.setAchievementImageUrl("DEFAULT");
        achievementModel.setRarityModel(rarityModel);
        return achievementModel;
    }
}

package com.runapp.achievementservice.staticObject;

import com.runapp.achievementservice.dto.request.AchievementRequest;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;

import java.util.ArrayList;

public class StaticAchievement {

    public static AchievementModel achievementModel1(){
        RarityModel rarityModel2 = new RarityModel();
        rarityModel2.setAchievementModelList(new ArrayList<>());
        rarityModel2.setId(1L);
        rarityModel2.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel2);
        achievementModel.setStory_id(1L);
        return achievementModel;
    }

    public static AchievementModel achievementModel2() {
        RarityModel rarityModel2 = new RarityModel();
        rarityModel2.setAchievementModelList(new ArrayList<>());
        rarityModel2.setId(2L);
        rarityModel2.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(2L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel2);
        achievementModel.setStory_id(2L);
        return achievementModel;
    }


    public static AchievementRequest achievementRequest(){
        AchievementRequest achievementRequest = new AchievementRequest();
        achievementRequest.setDescription("The characteristics of someone or something");
        achievementRequest.setName("Name");
        achievementRequest.setRarity_id(1L);
        achievementRequest.setStory_id(1L);
        return achievementRequest;
    }


}

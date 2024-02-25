package com.runapp.achievementservice.staticObject;

import com.runapp.achievementservice.dto.request.RarityRequest;
import com.runapp.achievementservice.model.RarityModel;

import java.util.ArrayList;

public class StaticRarity {
    public static RarityModel rarityModel1(){
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        return rarityModel;
    }

    public static RarityRequest rarityRequest1(){
        RarityRequest rarityRequest = new RarityRequest();
        rarityRequest.setName("Name");
        return rarityRequest;
    }
}

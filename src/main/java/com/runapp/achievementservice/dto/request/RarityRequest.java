package com.runapp.achievementservice.dto.request;

import com.runapp.achievementservice.model.RarityModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RarityRequest {

    private String name;

    public RarityModel toRarityModel() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setName(this.name);
        return rarityModel;
    }
}

package com.runapp.achievementservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementDeleteRequest {

    private String file_uri;
    private int achievement_id;
}

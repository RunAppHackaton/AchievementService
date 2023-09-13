package com.runapp.achievementservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryResponse {

    private int id;

    private String tittle;

    private String description;

    private String category;

    private int difficultLevel;

    private String storyImageUrl;

    private List<TaskResponse> taskModelList;
}

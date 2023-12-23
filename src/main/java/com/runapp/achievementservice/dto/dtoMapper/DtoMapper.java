package com.runapp.achievementservice.dto.dtoMapper;

import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;

import java.util.List;

public interface DtoMapper<Model, Request, Response> {
    Model toModel(Request request);
    Response toResponse(Model model);

    List<Response> toResponseList(List<Model> modelList);
}

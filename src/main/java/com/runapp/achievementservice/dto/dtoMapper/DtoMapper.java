package com.runapp.achievementservice.dto.dtoMapper;

public interface DtoMapper<Model, Request, Response> {
    Model toModel(Request request);
    Response toResponse(Model model);
}

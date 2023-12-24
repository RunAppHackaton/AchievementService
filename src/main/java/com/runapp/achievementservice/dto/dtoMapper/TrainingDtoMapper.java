package com.runapp.achievementservice.dto.dtoMapper;

import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingDtoMapper implements DtoMapper<TrainingModel, TrainingRequest, TrainingResponse> {
    @Override
    public TrainingModel toModel(TrainingRequest trainingRequest) {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(trainingRequest.getTraining_date());
        trainingModel.setUserId(trainingRequest.getUserId());
        trainingModel.setDuration(trainingRequest.getTraining_duration());
        trainingModel.setDistanceKm(trainingRequest.getDistance_km());
        trainingModel.setAveragePace(trainingRequest.getPace());
        return trainingModel;
    }

    @Override
    public TrainingResponse toResponse(TrainingModel trainingModel) {
        TrainingResponse response = new TrainingResponse();
        response.setTraining_date(trainingModel.getDateTraining());
        response.setUserId(trainingModel.getUserId());
        response.setTraining_duration(trainingModel.getDuration());
        response.setDistance_km(trainingModel.getDistanceKm());
        response.setPace(trainingModel.getAveragePace());
        return response;
    }

    public List<TrainingResponse> toResponseList(List<TrainingModel> trainingModels) {
        return trainingModels.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

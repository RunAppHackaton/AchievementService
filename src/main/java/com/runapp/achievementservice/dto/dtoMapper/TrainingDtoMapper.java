package com.runapp.achievementservice.dto.dtoMapper;

import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;

import java.time.Duration;

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
        return TrainingResponse.builder()
                .training_date(trainingModel.getDateTraining())
                .userId(trainingModel.getUserId())
                .training_duration(trainingModel.getDuration())
                .distance_km(trainingModel.getDistanceKm())
                .pace(trainingModel.getAveragePace())
                .build();
    }
}

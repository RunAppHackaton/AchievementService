package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.service.serviceTemplate.CrudOperations;

import java.util.List;

public interface TrainingService extends CrudOperations<TrainingModel> {
    List<TrainingModel> getAllTrainingsByUserId(Long userId);
}

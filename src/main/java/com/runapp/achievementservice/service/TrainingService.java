package com.runapp.achievementservice.service;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.service.goalUpdater.GoalUpdater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {

    private final GoalUpdater goalUpdater;
    private final TrainingRepository trainingRepository;
    private final UserStatisticService userStatisticService;

    public TrainingModel saveTraining(TrainingModel training) {
        userStatisticService.startTrackingUserStatisticsIfNone(training.getUserId());
        TrainingModel savedTraining = trainingRepository.save(training);
        goalUpdater.updateAllGoal(savedTraining.getUserId());
        return savedTraining;
    }

    public List<TrainingModel> getAllTrainingsByUserId(Long userId) {
        return trainingRepository.findAllByUserId(userId);
    }

    public TrainingModel getTrainingById(Integer id) {
        return trainingRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Training not found with id: " + id));
    }

    public List<TrainingModel> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public void deleteTrainingById(Integer id) {
        if (trainingRepository.existsById(id)) {
            trainingRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Training not found with id: " + id);
        }
    }
}

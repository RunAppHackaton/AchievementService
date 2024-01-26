package com.runapp.achievementservice.service.serviceImpl;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.service.serviceTemplate.CrudOperations;
import com.runapp.achievementservice.util.supportClasses.goalUpdater.GoalUpdater;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingServiceImpl implements CrudOperations<TrainingModel> {

    private final GoalUpdater goalUpdater;
    private final TrainingRepository trainingRepository;
    private final UserStatisticServiceImpl userStatisticServiceImpl;
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingServiceImpl.class);

    @Override
    public TrainingModel add(TrainingModel training) {
        LOGGER.info("Training add: {}", training);
        userStatisticServiceImpl.startTrackingUserStatisticsIfNone(training.getUserId());
        TrainingModel savedTraining = trainingRepository.save(training);
        userStatisticServiceImpl.addTrainingInStatistic(training);
        goalUpdater.updateAllGoal(savedTraining.getUserId());
        return savedTraining;
    }

    @Override
    public List<TrainingModel> getAll() {
        LOGGER.info("Training get all");
        return trainingRepository.findAll();
    }

    @Override
    public TrainingModel getById(Long id) {
        LOGGER.info("Training get by id: {}", id);
        return trainingRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Training not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("Training delete by id: {}", id);
        if (trainingRepository.existsById(id)) {
            trainingRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Training not found with id: " + id);
        }
    }

    @Override
    public TrainingModel update(TrainingModel updatedTraining) {
        LOGGER.info("Training update: {}", updatedTraining);
        if (trainingRepository.existsById(updatedTraining.getId())) {
            return trainingRepository.save(updatedTraining);
        } else {
            throw new NoEntityFoundException("Training not found with id: " + updatedTraining.getId());
        }
    }

    public List<TrainingModel> getAllTrainingsByUserId(Long userId) {
        LOGGER.info("Training get all by UserId: {}", userId);
        return trainingRepository.findAllByUserId(userId);
    }
}

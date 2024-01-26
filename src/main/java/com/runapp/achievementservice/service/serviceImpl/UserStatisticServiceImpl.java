package com.runapp.achievementservice.service.serviceImpl;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.service.UserStatisticService;
import com.runapp.achievementservice.util.supportClasses.TrainingObserver;
import com.runapp.achievementservice.util.supportClasses.TrainingStatisticsUpdater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class UserStatisticServiceImpl implements UserStatisticService {

    private final UserStatisticRepository progressRepository;
    private final TrainingObserver trainingObserver;
    private final TrainingStatisticsUpdater statisticsUpdater;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserStatisticServiceImpl.class);

    @Autowired
    public UserStatisticServiceImpl(UserStatisticRepository progressRepository, TrainingObserver trainingObserver) {
        this.progressRepository = progressRepository;
        this.trainingObserver = trainingObserver;
        this.statisticsUpdater = new TrainingStatisticsUpdater(this);
    }

    @Override
    public List<UserStatisticModel> getAllProgress() {
        LOGGER.info("UserStatistic get all");
        return progressRepository.findAll();
    }

    @Override
    public void deleteTrackingUserStatistics(Long userId) {
        LOGGER.info("UserStatistic delete by id: {}", userId);
        trainingObserver.deleteObserverForUserAchievements(userId);
        progressRepository.deleteById(userId);
    }

    @Override
    public UserStatisticModel getCurrentProgressById(Long userId) {
        LOGGER.info("UserStatistic get by id: {}", userId);
        return progressRepository.findById(userId)
                .orElseThrow(() -> new NoEntityFoundException("Progress not found with user id: " + userId));
    }

    @Override
    public UserStatisticModel updateProgress(UserStatisticModel updatedProgress) {
        LOGGER.info("UserStatistic update : {}", updatedProgress);
        if (progressRepository.existsById(updatedProgress.getUserId())) {
            return progressRepository.save(updatedProgress);
        } else {
            throw new NoEntityFoundException("Progress not found with user id: " + updatedProgress.getUserId());
        }
    }

    @Override
    public void startTrackingUserStatisticsIfNone(Long userId) {
        LOGGER.info("UserStatistic start tracking if doesn't exist by id: {}", userId);
        if (!progressRepository.existsById(userId)) {
            createEmptyStatistic(userId);
            trainingObserver.createNewObserverForUserGoals(userId, getCurrentProgressById(userId));
        }
    }

    private void createEmptyStatistic(Long userId) {
        LOGGER.info("UserStatistic add empty with id: {}", userId);
        UserStatisticModel statisticModel = new UserStatisticModel();
        statisticModel.setUserId(userId);
        statisticModel.setNumberOfWorkoutsPerWeek(0L);
        statisticModel.setNumberOfWorkoutsPerMonth(0L);
        statisticModel.setNumberOfWorkoutsPerYear(0L);
        statisticModel.setNumberOfTrainingSessionsOverTime(0L);
        statisticModel.setTotalNumberOfWorkoutsForAllTime(0L);
        statisticModel.setTotalAmountOfTrainingTime(Duration.ZERO);
        statisticModel.setAveragePaceRecord(Duration.ZERO);
        progressRepository.save(statisticModel);
    }

    @Override
    public void addTrainingInStatistic(TrainingModel trainingModel) {
        statisticsUpdater.updateStatisticsByTrainingType(trainingModel);
    }
}

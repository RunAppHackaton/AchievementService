package com.runapp.achievementservice.service;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.supportClasses.TrainingObserver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@AllArgsConstructor
public class UserStatisticService {

    private final UserStatisticRepository progressRepository;
    private final TrainingObserver trainingObserver;

    public List<UserStatisticModel> getAllProgress() {
        return progressRepository.findAll();
    }


    public void deleteTrackingUserStatistics(Long userId) {
        trainingObserver.deleteObserverForUserAchievements(userId);
        progressRepository.deleteById(userId);
    }

    public UserStatisticModel getCurrentProgressById(Long userId) {
        return progressRepository.findById(userId)
                .orElseThrow(() -> new NoEntityFoundException("Progress not found with user id: " + userId));
    }

    public UserStatisticModel updateProgress(UserStatisticModel updatedProgress) {
        if (progressRepository.existsById(updatedProgress.getUserId())) {
            return progressRepository.save(updatedProgress);
        } else {
            throw new NoEntityFoundException("Progress not found with user id: " + updatedProgress.getUserId());
        }
    }

    public void startTrackingUserStatisticsIfNone(Long userId) {
        if (!progressRepository.existsById(userId)) {
            createEmptyStatistic(userId);
            trainingObserver.createNewObserverForUserGoals(userId, getCurrentProgressById(userId));
        }
    }

    private void createEmptyStatistic(Long userId) {
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

}

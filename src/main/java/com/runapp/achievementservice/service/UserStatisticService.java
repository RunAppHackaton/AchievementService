package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;

import java.time.Duration;
import java.util.List;

public interface UserStatisticService {

    List<UserStatisticModel> getAllProgress();

    void deleteTrackingUserStatistics(Long userId);

    UserStatisticModel getCurrentProgressById(Long userId);

    UserStatisticModel updateProgress(UserStatisticModel updatedProgress);

    void startTrackingUserStatisticsIfNone(Long userId);

    void addTrainingInStatistic(TrainingModel trainingModel);
}

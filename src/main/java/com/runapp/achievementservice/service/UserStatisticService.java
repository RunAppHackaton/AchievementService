package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;

import java.time.Duration;
import java.util.List;

public interface UserStatisticService {

    List<UserStatisticModel> getAllProgress();

    void deleteTrackingUserStatistics(String userId);

    UserStatisticModel getCurrentProgressById(String userId);

    UserStatisticModel updateProgress(UserStatisticModel updatedProgress);

    void startTrackingUserStatisticsIfNone(String userId);

    void addTrainingInStatistic(TrainingModel trainingModel);
}

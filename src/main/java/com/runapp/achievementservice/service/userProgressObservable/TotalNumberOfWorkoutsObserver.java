package com.runapp.achievementservice.service.userProgressObservable;

import com.runapp.achievementservice.model.UserProgressInAchievementModel;

public class TotalNumberOfWorkoutsObserver implements UserProgressObserver {
    @Override
    public void update(UserProgressInAchievementModel userProgress) {
        // Логика обновления данных для типа цели TOTAL_NUMBER_OF_WORKOUTS
        // Например:
        userProgress.setTotalNumberOfWorkoutsForAllTime(userProgress.getTotalNumberOfWorkoutsForAllTime() + 1);
    }

    @Override
    public void reset(UserProgressInAchievementModel userProgress) {
        // Логика обнуления данных для типа цели TOTAL_NUMBER_OF_WORKOUTS
        // Например:
        userProgress.setTotalNumberOfWorkoutsForAllTime(0L);
    }
}

package com.runapp.achievementservice.service.userProgressObservable;

import com.runapp.achievementservice.model.UserProgressInAchievementModel;

public interface UserProgressObserver {
    void update(UserProgressInAchievementModel userProgress);
    void reset(UserProgressInAchievementModel userProgress);
}

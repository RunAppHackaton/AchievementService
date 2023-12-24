package com.runapp.achievementservice.util.supportClasses;

import java.time.Duration;

public class GoalCompletionCalculator {

    public static float calculatePercentage(Duration sumDurationAllTraining, Duration currentGoalDuration) {
        float totalMillis = (float) sumDurationAllTraining.toMillis();
        float currentMillis = (float) currentGoalDuration.toMillis();
        return (currentMillis / totalMillis) * 100.0f;
    }

    public static float calculatePercentage(int totalCountTraining, int currentCountTraining) {
        float totalCount = totalCountTraining;
        float currentCount = currentCountTraining;
        return (currentCount / totalCount) * 100;
    }
}

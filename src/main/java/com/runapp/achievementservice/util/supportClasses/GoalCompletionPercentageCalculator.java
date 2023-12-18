package com.runapp.achievementservice.util.supportClasses;

import java.time.Duration;

public class GoalCompletionPercentageCalculator {

    public static float calculatePercentage(Duration totalDuration, Duration currentDuration) {
        float totalMillis = (float) totalDuration.toMillis();
        float currentMillis = (float) currentDuration.toMillis();
        return (currentMillis / totalMillis) * 100.0f;
    }

    public static float calculatePercentage(int totalCountTraining, int currentCountTraining) {
        float totalCount = totalCountTraining;
        float currentCount = currentCountTraining;
        return (currentCount / totalCount) * 100;
    }
}
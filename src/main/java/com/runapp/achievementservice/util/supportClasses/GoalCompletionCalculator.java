package com.runapp.achievementservice.util.supportClasses;

import java.time.Duration;

public class GoalCompletionCalculator {

    public static double calculatePercentage(Duration sumDurationAllTraining, Duration currentGoalDuration) {
        return ((double) sumDurationAllTraining.toMillis() / currentGoalDuration.toMillis()) * 100.0;
    }

    public static long calculatePercentage(int totalCountTraining, int currentCountTraining) {
        return ((long) currentCountTraining / (long) totalCountTraining) * 100;
    }
}

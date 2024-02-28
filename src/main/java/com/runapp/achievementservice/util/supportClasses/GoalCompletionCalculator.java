package com.runapp.achievementservice.util.supportClasses;

import java.time.Duration;

public class GoalCompletionCalculator {

    public static double calculatePercentage(Duration currentAveragePace, Duration goalAveragePace) {
        double currentPaceSeconds = (double) currentAveragePace.toMillis() / 1000;
        double goalPaceSeconds = (double) goalAveragePace.toMillis() / 1000;

        return (currentPaceSeconds / goalPaceSeconds) * 100.0;
    }

    public static long calculatePercentage(int totalCountTraining, int currentCountTraining) {
        return ((long) currentCountTraining / (long) totalCountTraining) * 100;
    }
}

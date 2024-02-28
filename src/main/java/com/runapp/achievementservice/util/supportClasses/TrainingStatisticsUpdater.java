package com.runapp.achievementservice.util.supportClasses;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.service.serviceImpl.UserStatisticServiceImpl;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class TrainingStatisticsUpdater {

    private final UserStatisticServiceImpl userStatisticServiceImpl;

    public TrainingStatisticsUpdater(UserStatisticServiceImpl userStatisticServiceImpl) {
        this.userStatisticServiceImpl = userStatisticServiceImpl;
    }

    public void updateStatisticsByTrainingType(TrainingModel trainingModel) {
        UserStatisticModel statisticModel = userStatisticServiceImpl.getCurrentProgressById(trainingModel.getUserId());

        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_TRAINING_TIME, trainingModel.getDuration().getSeconds());
        updateStatisticsByType(statisticModel, GoalTypeEnum.AVERAGE_RUNNING_PACE, trainingModel.getAveragePace().getSeconds());
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_KILOMETERS, trainingModel.getDistanceKm());

        userStatisticServiceImpl.updateProgress(statisticModel);
    }

    private void updateStatisticsByType(UserStatisticModel statisticModel, GoalTypeEnum trainingType, long value) {
        switch (trainingType) {
            case TOTAL_TRAINING_TIME -> increaseTotalTrainingTimeByTime(statisticModel, value);
            case AVERAGE_RUNNING_PACE -> updateAverageRunningPace(statisticModel, value);
            case TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK -> increaseNumberOfWorkoutsPerWeekByValue(statisticModel, value);
            case TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH -> increaseNumberOfWorkoutsPerMonthByValue(statisticModel, value);
            case TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR -> increaseNumberOfWorkoutsPerYearByValue(statisticModel, value);
            case TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME ->
                    increaseNumberOfTrainingSessionsOverTimeByValue(statisticModel, value);
            case TOTAL_KILOMETERS -> increaseTotalNumberOfWorkoutsForAllTimeByValue(statisticModel, value);
            default -> throw new IllegalArgumentException("Unsupported training type: " + trainingType);
        }
    }

    private void increaseTotalTrainingTimeByTime(UserStatisticModel statisticModel, long seconds) {
        Duration currentTotalTrainingTime = statisticModel.getTotalAmountOfTrainingTime();
        if (currentTotalTrainingTime == null) {
            currentTotalTrainingTime = Duration.ZERO;
        }
        statisticModel.setTotalAmountOfTrainingTime(currentTotalTrainingTime.plus(Duration.ofSeconds(seconds)));
    }

    private void updateAverageRunningPace(UserStatisticModel statisticModel, long seconds) {
        Duration paceDuration = Duration.ofSeconds(seconds);
        Duration currentAveragePace = statisticModel.getAveragePaceRecord();

        if (currentAveragePace == null || paceDuration.compareTo(currentAveragePace) < 0) {
            statisticModel.setAveragePaceRecord(paceDuration);
        }
    }

    private void increaseNumberOfWorkoutsPerWeekByValue(UserStatisticModel statisticModel, long value) {
        Long numberOfWorkoutsPerWeek = statisticModel.getNumberOfWorkoutsPerWeek();
        long currentValue = numberOfWorkoutsPerWeek != null ? numberOfWorkoutsPerWeek : 0L;
        statisticModel.setNumberOfWorkoutsPerWeek(currentValue + value);
    }

    private void increaseNumberOfWorkoutsPerMonthByValue(UserStatisticModel statisticModel, long value) {
        Long numberOfWorkoutsPerMonth = statisticModel.getNumberOfWorkoutsPerMonth();
        long currentValue = numberOfWorkoutsPerMonth != null ? numberOfWorkoutsPerMonth : 0L;
        statisticModel.setNumberOfWorkoutsPerMonth(currentValue + value);
    }

    private void increaseNumberOfWorkoutsPerYearByValue(UserStatisticModel statisticModel, long value) {
        Long numberOfWorkoutsPerYear = statisticModel.getNumberOfWorkoutsPerYear();
        long currentValue = numberOfWorkoutsPerYear != null ? numberOfWorkoutsPerYear : 0L;
        statisticModel.setNumberOfWorkoutsPerYear(currentValue + value);
    }

    private void increaseNumberOfTrainingSessionsOverTimeByValue(UserStatisticModel statisticModel, long value) {
        Long numberOfTrainingSessionsOverTime = statisticModel.getNumberOfTrainingSessionsOverTime();
        long currentValue = numberOfTrainingSessionsOverTime != null ? numberOfTrainingSessionsOverTime : 0L;
        statisticModel.setNumberOfTrainingSessionsOverTime(currentValue + value);
    }

    private void increaseTotalNumberOfWorkoutsForAllTimeByValue(UserStatisticModel statisticModel, long value) {
        Long totalNumberOfWorkoutsForAllTime = statisticModel.getTotalNumberOfWorkoutsForAllTime();
        long currentValue = totalNumberOfWorkoutsForAllTime != null ? totalNumberOfWorkoutsForAllTime : 0L;
        statisticModel.setTotalNumberOfWorkoutsForAllTime(currentValue + value);
    }

}

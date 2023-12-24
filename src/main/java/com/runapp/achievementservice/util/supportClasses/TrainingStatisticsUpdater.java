package com.runapp.achievementservice.util.supportClasses;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.service.UserStatisticService;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@AllArgsConstructor
public class TrainingStatisticsUpdater {

    private final UserStatisticService userStatisticService;

    public void updateStatisticsByTrainingType(TrainingModel trainingModel) {
        UserStatisticModel statisticModel = userStatisticService.getCurrentProgressById(trainingModel.getUserId());

        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_TRAINING_TIME, trainingModel.getDuration().getSeconds());
        updateStatisticsByType(statisticModel, GoalTypeEnum.AVERAGE_RUNNING_PACE, trainingModel.getAveragePace().getSeconds());
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME, 1);
        updateStatisticsByType(statisticModel, GoalTypeEnum.TOTAL_KILOMETERS, trainingModel.getDistanceKm());

        userStatisticService.updateProgress(statisticModel);
    }

    private void updateStatisticsByType(UserStatisticModel statisticModel, GoalTypeEnum trainingType, long value) {
        switch (trainingType) {
            case TOTAL_TRAINING_TIME:
                increaseTotalTrainingTimeByTime(statisticModel, value);
                break;
            case AVERAGE_RUNNING_PACE:
                updateAverageRunningPace(statisticModel, value);
                break;
            case TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK:
                increaseNumberOfWorkoutsPerWeekByValue(statisticModel, value);
                break;
            case TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH:
                increaseNumberOfWorkoutsPerMonthByValue(statisticModel, value);
                break;
            case TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR:
                increaseNumberOfWorkoutsPerYearByValue(statisticModel, value);
                break;
            case TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME:
                increaseNumberOfTrainingSessionsOverTimeByValue(statisticModel, value);
                break;
            case TOTAL_KILOMETERS:
                increaseTotalNumberOfWorkoutsForAllTimeByValue(statisticModel, value);
                break;
            default:
                throw new IllegalArgumentException("Unsupported training type: " + trainingType);
        }
    }

    private void increaseTotalTrainingTimeByTime(UserStatisticModel statisticModel, long seconds) {
        statisticModel.setTotalAmountOfTrainingTime(statisticModel.getTotalAmountOfTrainingTime().plus(Duration.ofSeconds(seconds)));
    }

    private void updateAverageRunningPace(UserStatisticModel statisticModel, long seconds) {
        Duration paceDuration = Duration.ofSeconds(seconds);
        if (paceDuration.compareTo(statisticModel.getAveragePaceRecord()) < 0) {
            statisticModel.setAveragePaceRecord(paceDuration);
        }
    }

    private void increaseNumberOfWorkoutsPerWeekByValue(UserStatisticModel statisticModel, long value) {
        statisticModel.setNumberOfWorkoutsPerWeek(statisticModel.getNumberOfWorkoutsPerWeek() + value);
    }

    private void increaseNumberOfWorkoutsPerMonthByValue(UserStatisticModel statisticModel, long value) {
        statisticModel.setNumberOfWorkoutsPerMonth(statisticModel.getNumberOfWorkoutsPerMonth() + value);
    }

    private void increaseNumberOfWorkoutsPerYearByValue(UserStatisticModel statisticModel, long value) {
        statisticModel.setNumberOfWorkoutsPerYear(statisticModel.getNumberOfWorkoutsPerYear() + value);
    }

    private void increaseNumberOfTrainingSessionsOverTimeByValue(UserStatisticModel statisticModel, long value) {
        statisticModel.setNumberOfTrainingSessionsOverTime(statisticModel.getNumberOfTrainingSessionsOverTime() + value);
    }

    private void increaseTotalNumberOfWorkoutsForAllTimeByValue(UserStatisticModel statisticModel, long value) {
        statisticModel.setTotalNumberOfWorkoutsForAllTime(statisticModel.getTotalNumberOfWorkoutsForAllTime() + value);
    }

}

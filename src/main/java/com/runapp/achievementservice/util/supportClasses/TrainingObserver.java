package com.runapp.achievementservice.util.supportClasses;

import com.runapp.achievementservice.model.UserStatistic;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class TrainingObserver {

    private final GoalScheduler schedulerService;
    private final UserStatisticRepository userStatisticRepository;
    private final String TASK_PREFIX_FOR_WORKOUT_EVERY_WEEK = "CheckPerWeek_";
    private final String TASK_PREFIX_FOR_WORKOUT_EVERY_MONTH = "CheckPerMonth_";
    private final String TASK_PREFIX_FOR_WORKOUT_EVERY_YEAR = "CheckPerYear_";

    public TrainingObserver(GoalScheduler schedulerService, UserStatisticRepository userStatisticRepository) {
        this.schedulerService = schedulerService;
        this.userStatisticRepository = userStatisticRepository;
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////Create Observer//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    public void createNewObserverForUserAchievements(Long userId, UserStatistic model) {
        createObserverForCheckPerWeek(userId, model);
        createObserverForCheckPerMonth(userId, model);
        createObserverForCheckPerYear(userId, model);
    }

    private void createObserverForCheckPerWeek(Long userId, UserStatistic model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_WEEK + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerWeek(0L);
            userStatisticRepository.save(model);
        };

        Duration interval = Duration.ofDays(7);

        schedulerService.scheduleTask(taskName, interval, taskAction);
    }

    private void createObserverForCheckPerMonth(Long userId, UserStatistic model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_MONTH + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerMonth(0L);
            userStatisticRepository.save(model);
        };

        Duration interval = Duration.ofDays(30);

        schedulerService.scheduleTask(taskName, interval, taskAction);
    }

    private void createObserverForCheckPerYear(Long userId, UserStatistic model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_YEAR + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerYear(0L);
            userStatisticRepository.save(model);
        };

        Duration interval = Duration.ofDays(365);

        schedulerService.scheduleTask(taskName, interval, taskAction);
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////Delete Observer//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    public void deleteObserverForUserAchievements(Long userId) {
        schedulerService.cancelTask(TASK_PREFIX_FOR_WORKOUT_EVERY_WEEK + userId);
        schedulerService.cancelTask(TASK_PREFIX_FOR_WORKOUT_EVERY_MONTH + userId);
        schedulerService.cancelTask(TASK_PREFIX_FOR_WORKOUT_EVERY_YEAR + userId);
    }
}

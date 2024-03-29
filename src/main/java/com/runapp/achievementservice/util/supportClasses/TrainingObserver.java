package com.runapp.achievementservice.util.supportClasses;

import com.runapp.achievementservice.model.UserStatisticModel;
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

    public void createNewObserverForUserGoals(String userId, UserStatisticModel model) {
        createObserverForCheckPerWeek(userId, model);
        createObserverForCheckPerMonth(userId, model);
        createObserverForCheckPerYear(userId, model);
    }

    private void createObserverForCheckPerWeek(String userId, UserStatisticModel model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_WEEK + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerWeek(0L);
            userStatisticRepository.save(model);
        };

        Duration interval = Duration.ofDays(7);

        schedulerService.scheduleTask(taskName, interval, taskAction);
    }

    private void createObserverForCheckPerMonth(String userId, UserStatisticModel model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_MONTH + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerMonth(0L);
            userStatisticRepository.save(model);
        };

        Duration interval = Duration.ofDays(30);

        schedulerService.scheduleTask(taskName, interval, taskAction);
    }

    private void createObserverForCheckPerYear(String userId, UserStatisticModel model) {
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

    public void deleteObserverForUserAchievements(String userId) {
        schedulerService.cancelTask(TASK_PREFIX_FOR_WORKOUT_EVERY_WEEK + userId);
        schedulerService.cancelTask(TASK_PREFIX_FOR_WORKOUT_EVERY_MONTH + userId);
        schedulerService.cancelTask(TASK_PREFIX_FOR_WORKOUT_EVERY_YEAR + userId);
    }
}

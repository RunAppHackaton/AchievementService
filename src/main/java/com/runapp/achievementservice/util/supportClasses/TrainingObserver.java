package com.runapp.achievementservice.util.supportClasses;

import com.runapp.achievementservice.model.UserProgressInAchievementModel;
import com.runapp.achievementservice.repository.UserProgressInAchievementRepository;
import com.runapp.achievementservice.service.DynamicSchedulerService;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class TrainingObserver {

    private final DynamicSchedulerService schedulerService;
    private final UserProgressInAchievementRepository userProgressInAchievementRepository;
    private final String TASK_PREFIX_FOR_WORKOUT_EVERY_WEEK = "CheckPerWeek_";
    private final String TASK_PREFIX_FOR_WORKOUT_EVERY_MONTH = "CheckPerMonth_";
    private final String TASK_PREFIX_FOR_WORKOUT_EVERY_YEAR = "CheckPerYear_";

    public TrainingObserver(DynamicSchedulerService schedulerService, UserProgressInAchievementRepository userProgressInAchievementRepository) {
        this.schedulerService = schedulerService;
        this.userProgressInAchievementRepository = userProgressInAchievementRepository;
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////Create Observer//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    public void createNewObserverForUserAchievements(Long userId, UserProgressInAchievementModel model) {
        createObserverForCheckPerWeek(userId, model);
        createObserverForCheckPerMonth(userId, model);
        createObserverForCheckPerYear(userId, model);
    }

    private void createObserverForCheckPerWeek(Long userId, UserProgressInAchievementModel model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_WEEK + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerWeek(0L);
            userProgressInAchievementRepository.save(model);
        };

        Duration interval = Duration.ofDays(7);

        schedulerService.scheduleTask(taskName, interval, taskAction);
    }

    private void createObserverForCheckPerMonth(Long userId, UserProgressInAchievementModel model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_MONTH + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerMonth(0L);
            userProgressInAchievementRepository.save(model);
        };

        Duration interval = Duration.ofDays(30);

        schedulerService.scheduleTask(taskName, interval, taskAction);
    }

    private void createObserverForCheckPerYear(Long userId, UserProgressInAchievementModel model) {
        String taskName = TASK_PREFIX_FOR_WORKOUT_EVERY_YEAR + userId;

        Runnable taskAction = () -> {
            model.setNumberOfWorkoutsPerYear(0L);
            userProgressInAchievementRepository.save(model);
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

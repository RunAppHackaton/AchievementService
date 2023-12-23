package com.runapp.achievementservice.util.supportClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@Service
@EnableScheduling
public class GoalScheduler {
    private final TaskScheduler taskScheduler;
    private final Map<String, ScheduledFuture<?>> scheduledTasks = new HashMap<>();

    @Autowired
    public GoalScheduler(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public void scheduleTask(String taskName, Duration interval, Runnable taskAction) {
        ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(taskAction, new CronTrigger("0 */" + interval.toMinutes() + " * * * *"));
        scheduledTasks.put(taskName, scheduledFuture);
    }

    // Отменяет задачу по имени
    public void cancelTask(String taskName) {
        ScheduledFuture<?> scheduledFuture = scheduledTasks.remove(taskName);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}

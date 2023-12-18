package com.runapp.achievementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
@EnableScheduling
public class DynamicSchedulerService {
    private final TaskScheduler taskScheduler;
    private final Map<String, Runnable> scheduledTasks = new HashMap<>();

    @Autowired
    public DynamicSchedulerService(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    // Создает и запускает задачу с указанным именем, интервалом и действием
    public void scheduleTask(String taskName, Duration interval, Runnable taskAction) {
        scheduledTasks.put(taskName, taskAction);

        taskScheduler.schedule(taskAction, new CronTrigger("0 */" + interval.toMinutes() + " * * * *"));
    }

    // Отменяет задачу по имени
    public void cancelTask(String taskName) {
        Runnable task = scheduledTasks.remove(taskName);
        if (task != null) {
            // Отменяет задачу
//             taskScheduler.cancelTask(task);
        }
    }

    // Создает бин TaskScheduler для использования
    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }
}

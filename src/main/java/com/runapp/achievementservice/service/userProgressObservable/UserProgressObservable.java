package com.runapp.achievementservice.service.userProgressObservable;

import com.runapp.achievementservice.model.UserProgressInAchievementModel;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserProgressObservable {
    private Map<GoalTypeEnum, UserProgressObserver> observers = new HashMap<>();
    private UserProgressInAchievementModel userProgress;

    public void addObserver(GoalTypeEnum goalType, UserProgressObserver observer) {
        observers.put(goalType, observer);
    }

    public void removeObserver(GoalTypeEnum goalType) {
        observers.remove(goalType);
    }

    public void setUserProgress(UserProgressInAchievementModel userProgress) {
        this.userProgress = userProgress;
        notifyObservers();
    }

    private void notifyObservers() {
        for (UserProgressObserver observer : observers.values()) {
            observer.update(userProgress);
        }
    }

    // Добавленный метод для установки расписания обнуления счетчиков
    public void scheduleResetCounters() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        long initialDelay = calculateInitialDelay(); // Рассчитываем начальную задержку до следующего сброса
        long period = calculatePeriod(); // Рассчитываем период сброса

        scheduler.scheduleAtFixedRate(this::resetCounters, initialDelay, period, TimeUnit.SECONDS);
    }

    // Добавленные методы для расчета начальной задержки и периода сброса
    private long calculateInitialDelay() {
        // Ваша логика расчета начальной задержки
        return 0; // Время до первого сброса
    }

    private long calculatePeriod() {
        // Ваша логика расчета периода сброса
        return TimeUnit.DAYS.toSeconds(30); // Пример: сброс каждые 30 дней
    }

    // Добавленный метод для сброса счетчиков
    private void resetCounters() {
        for (UserProgressObserver observer : observers.values()) {
            observer.reset(userProgress);
        }
        notifyObservers(); // Уведомляем наблюдателей о сбросе
    }
}

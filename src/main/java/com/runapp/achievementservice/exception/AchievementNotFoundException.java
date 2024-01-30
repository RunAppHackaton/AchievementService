package com.runapp.achievementservice.exception;

public class AchievementNotFoundException extends RuntimeException{
    public AchievementNotFoundException(String message) {
        super(message);
    }
    public AchievementNotFoundException() {
        super();
    }
}

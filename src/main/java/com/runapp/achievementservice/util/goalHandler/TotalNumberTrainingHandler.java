package com.runapp.achievementservice.util.goalHandler;

import org.springframework.stereotype.Component;

@Component
public class TotalNumberTrainingHandler implements GoalHandler {
    @Override
    public boolean isValid(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

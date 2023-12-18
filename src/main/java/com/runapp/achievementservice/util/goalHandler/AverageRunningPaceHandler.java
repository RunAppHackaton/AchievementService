package com.runapp.achievementservice.util.goalHandler;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AverageRunningPaceHandler implements GoalHandler {
    private static final Pattern AVERAGE_REGEX_PATTERN = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");

    @Override
    public boolean isValid(String input) {
        Matcher matcher = AVERAGE_REGEX_PATTERN.matcher(input);
        return matcher.matches();
    }
}

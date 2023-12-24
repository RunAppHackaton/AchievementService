package com.runapp.achievementservice.util.goalHandler;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GoalFactoryHandler {
    private final Map<GoalTypeEnum, GoalHandler> goalTypeMap;

    public GoalFactoryHandler() {
        this.goalTypeMap = initializationgGoalTypeMap();
    }

    public boolean isValid(GoalTypeEnum goalTypeEnum, String input) {
        if (goalTypeMap.containsKey(goalTypeEnum)) {
            return goalTypeMap.get(goalTypeEnum).isValid(input);
        } else {
            throw new NoEntityFoundException("Incorrect enum.\n" +
                                             "All valid formats: " + Arrays.toString(GoalTypeEnum.values()));
        }
    }

    private static Map<GoalTypeEnum, GoalHandler> initializationgGoalTypeMap() {
        Map<GoalTypeEnum, GoalHandler> goalTypeMap = new HashMap<>();
        goalTypeMap.put(GoalTypeEnum.TOTAL_TRAINING_TIME, new TotalTrainingTimeHandler());
        goalTypeMap.put(GoalTypeEnum.AVERAGE_RUNNING_PACE, new AverageRunningPaceHandler());
        goalTypeMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK, new TotalNumberTrainingHandler());
        goalTypeMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH, new TotalNumberTrainingHandler());
        goalTypeMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR, new TotalNumberTrainingHandler());
        goalTypeMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME, new TotalNumberTrainingHandler());
        goalTypeMap.put(GoalTypeEnum.TOTAL_KILOMETERS, new TotalKilometersHandler());
        return goalTypeMap;
    }
}

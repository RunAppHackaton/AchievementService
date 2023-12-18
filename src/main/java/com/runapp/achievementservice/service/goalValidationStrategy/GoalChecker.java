package com.runapp.achievementservice.service.goalValidationStrategy;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserProgressInAchievementRepository;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@AllArgsConstructor
public class GoalChecker {

    private final HashMap<GoalTypeEnum, GoalStrategy> strategyHashMap;

    @Autowired
    public GoalChecker(GoalRepository goalRepository, UserProgressInAchievementRepository achievementRepository) {
        strategyHashMap = new HashMap<>();
        strategyHashMap.put(GoalTypeEnum.TOTAL_TRAINING_TIME, new TotalTrainingTimeStrategy(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.AVERAGE_RUNNING_PACE, new AverageRunningPaceStrategy(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK, new TotalNumberTrainingStrategy(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH, new TotalNumberTrainingStrategy(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR, new TotalNumberTrainingStrategy(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME, new TotalNumberTrainingStrategy(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_KILOMETERS, new TotalKilometersStrategy(goalRepository));
    }

    public void execute(GoalTypeEnum goalType, GoalModel goal, List<TrainingModel> allTrainings) {
        if (strategyHashMap.containsKey(goalType)) {
            strategyHashMap.get(goalType).execute(goal, allTrainings);
        } else {
            throw new RuntimeException(goalType + " does not exist");
        }
    }
}

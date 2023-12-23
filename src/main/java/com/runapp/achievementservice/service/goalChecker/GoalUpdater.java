package com.runapp.achievementservice.service.goalChecker;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@AllArgsConstructor
public class GoalChecker {

    private final HashMap<GoalTypeEnum, UpdateGoalStrategy> strategyHashMap;
    private final TrainingRepository trainingRepository;
    private final GoalRepository goalRepository;

    @Autowired
    public GoalChecker(GoalRepository goalRepository, UserStatisticRepository achievementRepository, TrainingRepository trainingRepository, GoalRepository goalRepository1) {
        this.trainingRepository = trainingRepository;
        this.goalRepository = goalRepository1;
        strategyHashMap = new HashMap<>();
        strategyHashMap.put(GoalTypeEnum.TOTAL_TRAINING_TIME, new TotalTrainingTimeStrategyUpdate(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.AVERAGE_RUNNING_PACE, new AverageRunningPaceStrategyUpdate(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK, new TotalNumberTrainingStrategyUpdate(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH, new TotalNumberTrainingStrategyUpdate(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR, new TotalNumberTrainingStrategyUpdate(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME, new TotalNumberTrainingStrategyUpdate(goalRepository, achievementRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_KILOMETERS, new TotalKilometersStrategyUpdate(goalRepository));
    }

    public void updateAllGoal() {

    }

    private List<TrainingModel> getAllTrainingsByUserId(Integer userId) {
        return trainingRepository.findAllByUserId(userId);
    }

    private void updateGoal(GoalTypeEnum goalType, GoalModel goal, Integer userId) {
        if (strategyHashMap.containsKey(goalType)) {
            strategyHashMap.get(goalType).updateGoal(goal, getAllTrainingsByUserId(userId));
        } else {
            throw new RuntimeException(goalType + " does not exist");
        }
    }

    private static 
}

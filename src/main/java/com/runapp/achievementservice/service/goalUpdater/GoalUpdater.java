package com.runapp.achievementservice.service.goalUpdater;

import com.runapp.achievementservice.exception.NoEntityFoundException;
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
public class GoalUpdater {

    private final HashMap<GoalTypeEnum, UpdateGoalStrategy> strategyHashMap;
    private final TrainingRepository trainingRepository;
    private final GoalRepository goalRepository;

    @Autowired
    public GoalUpdater(GoalRepository goalRepository,
                       UserStatisticRepository userStatisticRepository,
                       TrainingRepository trainingRepository) {

        this.trainingRepository = trainingRepository;
        this.goalRepository = goalRepository;
        strategyHashMap = initializationStrategyHashMap(goalRepository, userStatisticRepository);
    }

    public void updateAllGoal(Long userId) {
        final List<TrainingModel> userAllTrainings = getAllTrainingsByUserId(userId);
        final List<GoalModel> userAllGoals = getAllGoalsByUserId(userId);

        for (GoalModel goal : userAllGoals) {
            updateGoal(goal.getGoalType().getGoalTypeEnum(), goal, userAllTrainings);
        }
    }


    private void updateGoal(GoalTypeEnum goalType, GoalModel goal, List<TrainingModel> allTrainingsByUserId) {
        if (strategyHashMap.containsKey(goalType)) {
            strategyHashMap.get(goalType).updateGoal(goal, allTrainingsByUserId);
        } else {
            throw new RuntimeException(goalType + " does not exist");
        }
    }

    private static HashMap<GoalTypeEnum, UpdateGoalStrategy> initializationStrategyHashMap(
            GoalRepository goalRepository,
            UserStatisticRepository userStatisticRepository) {

        HashMap<GoalTypeEnum, UpdateGoalStrategy> strategyHashMap = new HashMap<>();
        strategyHashMap.put(GoalTypeEnum.TOTAL_TRAINING_TIME, new TotalTrainingTimeStrategyUpdate(goalRepository, userStatisticRepository));
        strategyHashMap.put(GoalTypeEnum.AVERAGE_RUNNING_PACE, new AverageRunningPaceStrategyUpdate(goalRepository, userStatisticRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK, new TotalNumberTrainingStrategyUpdate(goalRepository, userStatisticRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH, new TotalNumberTrainingStrategyUpdate(goalRepository, userStatisticRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR, new TotalNumberTrainingStrategyUpdate(goalRepository, userStatisticRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME, new TotalNumberTrainingStrategyUpdate(goalRepository, userStatisticRepository));
        strategyHashMap.put(GoalTypeEnum.TOTAL_KILOMETERS, new TotalKilometersStrategyUpdate(goalRepository));
        return strategyHashMap;
    }


    private List<TrainingModel> getAllTrainingsByUserId(Long userId) {
        final List<TrainingModel> userAllTrainings = trainingRepository.findAllByUserId(userId);
        if (userAllTrainings.isEmpty()) {
            throw new NoEntityFoundException("the user with the ID " + userId + " does not have a single training");
        }
        return userAllTrainings;
    }

    private List<GoalModel> getAllGoalsByUserId(Long userId) {
        final List<GoalModel> userAllGoals = goalRepository.findAllByUserId(userId);
        if (userAllGoals.isEmpty()) {
            throw new NoEntityFoundException("the user with the ID " + userId + " does not have a single goal");
        }
        return userAllGoals;
    }
}

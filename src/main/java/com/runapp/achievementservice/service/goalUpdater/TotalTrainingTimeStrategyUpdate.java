package com.runapp.achievementservice.service.goalUpdater;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.supportClasses.GoalCompletionCalculator;
import com.runapp.achievementservice.util.supportClasses.GoalMark;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TotalTrainingTimeStrategyUpdate implements UpdateGoalStrategy {

    private final GoalRepository goalRepository;
    private final UserStatisticRepository achievementRepository;

    public TotalTrainingTimeStrategyUpdate(GoalRepository goalRepository, UserStatisticRepository achievementRepository) {
        this.goalRepository = goalRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void updateGoal(GoalModel model, List<TrainingModel> allTraining) {
        UserStatisticModel userProgress = achievementRepository.findById(model.getUserId()).orElse(new UserStatisticModel());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(model.getGoal(), formatter);

        // Создание объекта Duration на основе значений часов, минут и секунд
        Duration currentGoalDuration = Duration.ofHours(localTime.getHour())
                .plusMinutes(localTime.getMinute())
                .plusSeconds(localTime.getSecond());

        Duration sumDurationAllTraining = userProgress.getTotalAmountOfTrainingTime();
//        Duration currentGoalDuration = Duration.parse(model.getGoal());

        if (sumDurationAllTraining.compareTo(currentGoalDuration) >= 0) {
            GoalMark.finishGoal(model);
        } else {
            model.setCompletionPercentage(
                    GoalCompletionCalculator.calculatePercentage(sumDurationAllTraining, currentGoalDuration)
            );
        }
        goalRepository.save(model);
    }
}

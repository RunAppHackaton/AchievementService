package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserProgressInAchievementModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.repository.UserProgressInAchievementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AchievementProgressService {

    private final GoalRepository goalRepository;
    private final UserProgressInAchievementRepository userProgressInAchievementRepository;
    private final AchievementRepository achievementRepository;
    private final TrainingRepository trainingRepository;

    public UserProgressInAchievementModel updateProgressInAchievement(TrainingModel trainingModel) {
        // записать тренировку в базу
        trainingRepository.save(trainingModel);

        //обновления прогресса в таблицах


        // проверки на выполнение целей


        // ответ




        return null;
    }
}

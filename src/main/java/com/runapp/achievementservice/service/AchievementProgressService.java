package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.UserProgressInAchievementModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserProgressInAchievementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AchievementProgressService {

    private final GoalRepository goalRepository;
    private final UserProgressInAchievementRepository userProgressInAchievementRepository;
    private final AchievementRepository achievementRepository;

    public UserProgressInAchievementModel updateProgressInAchievement() {
        // записать тренировку в базу
        // проверки на выполнение целей
        // ответ




        return null;
    }
}

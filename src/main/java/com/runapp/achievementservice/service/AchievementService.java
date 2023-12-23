package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.service.goalChecker.GoalChecker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AchievementService {
    private final AchievementRepository achievementRepository;
    private final GoalChecker goalChecker;
    private final TrainingRepository trainingRepository;
    private

    public AchievementModel createAchievement(AchievementModel achievementModel) {
        return achievementRepository.save(achievementModel);
    }

    public Optional<AchievementModel> getAchievementById(int id) {
        return achievementRepository.findById(id);
    }

    public AchievementModel updateAchievement(AchievementModel achievementModel) {
        return achievementRepository.save(achievementModel);
    }

    public void deleteAchievement(int id) {
        achievementRepository.deleteById(id);
    }

    public List<AchievementModel> getAchievementsByStoryId(int storyId) {
        return achievementRepository.findByStory_id(storyId);
    }

    public List<AchievementModel> getAllAchievements() {
        return achievementRepository.findAll();
    }

    public List<AchievementModel> awardAchievement(TrainingModel trainingModel) {
        trainingRepository.save(trainingModel);
        List<TrainingModel> trainingModels = trainingRepository.findAllByUserId(trainingModel.getUserId());

        goalChecker.updateGoal();
        return null;
    }
}

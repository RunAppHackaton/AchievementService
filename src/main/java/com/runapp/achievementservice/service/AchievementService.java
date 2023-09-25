package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AchievementService {
    private final AchievementRepository achievementRepository;

    @Autowired
    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

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

    public AchievementModel getRandomAchievement(int storyId) {
        List<AchievementModel> achievementModelList = achievementRepository.findByStory_id(storyId);
        if (!achievementModelList.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(achievementModelList.size());
            return achievementModelList.get(randomIndex);
        }
        return null;
    }
}

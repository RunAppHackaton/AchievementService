package com.runapp.achievementservice.service;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AchievementService {
    private final AchievementRepository achievementRepository;

    public AchievementModel createAchievement(AchievementModel achievementModel) {
        return achievementRepository.save(achievementModel);
    }

    public Optional<AchievementModel> getAchievementById(int id) {
        return achievementRepository.findById(id);
    }

    public AchievementModel updateAchievement(AchievementModel achievementModel) {
        if (achievementRepository.existsById(achievementModel.getId())) {
            return achievementRepository.save(achievementModel);
        } else {
            throw new NoEntityFoundException("Achievement not found with id: " + achievementModel.getId());
        }
    }

    public void deleteAchievement(int id) {
        if (achievementRepository.existsById(id)) {
            achievementRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Achievement not found with id: " + id);
        }
    }

    public List<AchievementModel> getAchievementsByStoryId(int storyId) {
        return achievementRepository.findByStory_id(storyId);
    }

    public List<AchievementModel> getAllAchievements() {
        return achievementRepository.findAll();
    }
}

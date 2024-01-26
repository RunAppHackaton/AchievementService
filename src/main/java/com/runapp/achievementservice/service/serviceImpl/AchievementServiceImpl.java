package com.runapp.achievementservice.service.serviceImpl;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AchievementServiceImpl {
    private final AchievementRepository achievementRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AchievementServiceImpl.class);

    public AchievementModel createAchievement(AchievementModel achievementModel) {
        LOGGER.info("Achievement add: {}", achievementModel);
        return achievementRepository.save(achievementModel);
    }

    public Optional<AchievementModel> getAchievementById(int id) {
        LOGGER.info("Achievement get by id: {}", id);
        return achievementRepository.findById(id);
    }

    public AchievementModel updateAchievement(AchievementModel achievementModel) {
        LOGGER.info("Achievement update: {}", achievementModel);
        if (achievementRepository.existsById(achievementModel.getId())) {
            return achievementRepository.save(achievementModel);
        } else {
            throw new NoEntityFoundException("Achievement not found with id: " + achievementModel.getId());
        }
    }

    public void deleteAchievement(int id) {
        LOGGER.info("Achievement delete by id: {}", id);
        if (achievementRepository.existsById(id)) {
            achievementRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Achievement not found with id: " + id);
        }
    }

    public List<AchievementModel> getAchievementsByStoryId(int storyId) {
        LOGGER.info("Achievement get by StoryId: {}", storyId);
        return achievementRepository.findByStory_id(storyId);
    }

    public List<AchievementModel> getAllAchievements() {
        LOGGER.info("Achievement get all");
        return achievementRepository.findAll();
    }
}

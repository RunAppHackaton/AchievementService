package com.runapp.achievementservice.service.serviceImpl;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AchievementServiceImpl {
    private final AchievementRepository achievementRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AchievementServiceImpl.class);

    @Caching(put = {
            @CachePut(value = "achievement", key = "#achievementModel.id"),
            @CachePut(value = "achievement-by-story_id", key = "'achievements-story-' + #achievementModel.story_id")},
            evict = {@CacheEvict(value = "achievement", allEntries = true)})
    public AchievementModel createAchievement(AchievementModel achievementModel) {
        LOGGER.info("Achievement add: {}", achievementModel);
        return achievementRepository.save(achievementModel);
    }


    @Cacheable(value = "achievement", key = "#id")
    public Optional<AchievementModel> getAchievementById(Long id) {
        LOGGER.info("Achievement get by id: {}", id);
        return achievementRepository.findById(id);
    }

    @Caching(put = {
            @CachePut(value = "achievement", key = "#achievementModel.id"),
            @CachePut(value = "achievement-by-story_id", key = "'achievements-story-' + #achievementModel.story_id")},
            evict = {@CacheEvict(value = "achievement", allEntries = true)})
    public AchievementModel updateAchievement(AchievementModel achievementModel) {
        LOGGER.info("Achievement update: {}", achievementModel);
        if (achievementRepository.existsById(achievementModel.getId())) {
            return achievementRepository.save(achievementModel);
        } else {
            throw new NoEntityFoundException("Achievement not found with id: " + achievementModel.getId());
        }
    }

    @CacheEvict(value = "achievement", key = "#id")
    public void deleteAchievement(Long id) {
        LOGGER.info("Achievement delete by id: {}", id);
        if (achievementRepository.existsById(id)) {
            achievementRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Achievement not found with id: " + id);
        }
    }

    @Cacheable(value = "achievement-by-story_id", key = "'achievements-story-' + #storyId")
    public List<AchievementModel> getAchievementsByStoryId(Long storyId) {
        LOGGER.info("Achievement get by StoryId: {}", storyId);
        return achievementRepository.findByStory_id(storyId);
    }

    @Cacheable(value = "achievement")
    public List<AchievementModel> getAllAchievements() {
        LOGGER.info("Achievement get all");
        return achievementRepository.findAll();
    }
}

package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.AchievementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<AchievementModel, Integer> {
    @Query("SELECT a FROM AchievementModel a WHERE a.story_id = :storyId")
    List<AchievementModel> findByStory_id(@Param("storyId") int storyId);
}

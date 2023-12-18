package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.UserProgressInAchievementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProgressInAchievementRepository extends JpaRepository
        <UserProgressInAchievementModel,
                Long> {
}

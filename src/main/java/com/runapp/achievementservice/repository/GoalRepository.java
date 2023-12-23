package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<GoalModel, Integer> {

    @Query("SELECT g FROM GoalModel g WHERE g.goalType.goalTypeEnum = :goalTypeEnum")
    List<GoalModel> findAllByGoalTypeEnum(@Param("goalTypeEnum") GoalTypeEnum goalTypeEnum);

    List<GoalModel> findAllByUserId(Long userId);
}

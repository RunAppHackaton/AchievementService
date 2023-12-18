package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingModel, Integer> {
    @Query("SELECT t FROM TrainingModel t ORDER BY t.averagePace ASC NULLS LAST")
    TrainingModel findTrainingWithMinAveragePace();
}

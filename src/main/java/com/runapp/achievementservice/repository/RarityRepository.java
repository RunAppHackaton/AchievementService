package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.RarityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RarityRepository extends JpaRepository<RarityModel, Long> {
}

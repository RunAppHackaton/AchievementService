package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.UserStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatisticRepository extends JpaRepository
        <UserStatistic,
                Long> {
}

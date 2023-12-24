package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.UserStatisticModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatisticRepository extends JpaRepository
        <UserStatisticModel,
                Long> {
}

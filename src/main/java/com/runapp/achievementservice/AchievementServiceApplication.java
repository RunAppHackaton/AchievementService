package com.runapp.achievementservice;

import com.runapp.achievementservice.dto.dtoMapper.GoalDtoMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCaching
public class AchievementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AchievementServiceApplication.class, args);
    }

}

package com.runapp.achievementservice.feignClient;

import com.runapp.achievementservice.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "profile-service")
public interface ProfileServiceClient {

    @GetMapping("/users/{userId}")
    ResponseEntity<UserResponse> getUserById(@PathVariable Long userId);
}

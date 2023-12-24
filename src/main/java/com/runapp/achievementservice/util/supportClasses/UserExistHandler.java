package com.runapp.achievementservice.util.supportClasses;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.feignClient.ProfileServiceClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserExistHandler {

    private final ProfileServiceClient profileServiceClient;

    public void checkUserExist(Long userId) {
        try {
            profileServiceClient.getUserById(userId);
        } catch (FeignException.NotFound e) {
            throw new NoEntityFoundException("User with id: " + userId + " doesn't exist");
        }
    }
}

package com.runapp.achievementservice.service;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.UserProgressInAchievementModel;
import com.runapp.achievementservice.repository.UserProgressInAchievementRepository;
import com.runapp.achievementservice.util.supportClasses.TrainingObserver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProgressInAchievementService {

    private final UserProgressInAchievementRepository progressRepository;
    private final TrainingObserver trainingObserver;

    public UserProgressInAchievementModel saveProgress(UserProgressInAchievementModel progress) {
        //create a observer for update achievement counter
        trainingObserver.createNewObserverForUserAchievements(progress.getUserId(), progress);

        return progressRepository.save(progress);
    }

    public List<UserProgressInAchievementModel> getAllProgress() {
        return progressRepository.findAll();
    }

    public UserProgressInAchievementModel getProgressById(Long userId) {
        return progressRepository.findById(userId)
                .orElseThrow(() -> new NoEntityFoundException("Progress not found with user id: " + userId));
    }

    public void deleteProgressById(Long userId) {
        //delete all observers for update achievement counter
        trainingObserver.deleteObserverForUserAchievements(userId);

        progressRepository.deleteById(userId);
    }

    public UserProgressInAchievementModel updateProgress(UserProgressInAchievementModel updatedProgress) {
        if (progressRepository.existsById(updatedProgress.getUserId())) {
            return progressRepository.save(updatedProgress);
        } else {
            throw new NoEntityFoundException("Progress not found with user id: " + updatedProgress.getUserId());
        }
    }
}

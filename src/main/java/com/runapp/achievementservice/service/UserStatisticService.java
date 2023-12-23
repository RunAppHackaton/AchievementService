package com.runapp.achievementservice.service;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.UserStatistic;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.supportClasses.TrainingObserver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserStatisticService {

    private final UserStatisticRepository progressRepository;
    private final TrainingObserver trainingObserver;

    public UserStatistic saveProgress(UserStatistic progress) {
        trainingObserver.createNewObserverForUserAchievements(progress.getUserId(), progress);
        return progressRepository.save(progress);
    }

    public List<UserStatistic> getAllProgress() {
        return progressRepository.findAll();
    }

    public UserStatistic getProgressById(Long userId) {
        return progressRepository.findById(userId)
                .orElseThrow(() -> new NoEntityFoundException("Progress not found with user id: " + userId));
    }

    public void deleteProgressById(Long userId) {
        //delete all observers for update achievement counter
        trainingObserver.deleteObserverForUserAchievements(userId);

        progressRepository.deleteById(userId);
    }

    public UserStatistic updateProgress(UserStatistic updatedProgress) {
        if (progressRepository.existsById(updatedProgress.getUserId())) {
            return progressRepository.save(updatedProgress);
        } else {
            throw new NoEntityFoundException("Progress not found with user id: " + updatedProgress.getUserId());
        }
    }
}

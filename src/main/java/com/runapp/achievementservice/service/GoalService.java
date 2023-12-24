package com.runapp.achievementservice.service;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;

    public GoalModel saveGoal(GoalModel goal) {
        return goalRepository.save(goal);
    }

    public List<GoalModel> getAllGoals() {
        return goalRepository.findAll();
    }

    public GoalModel getGoalById(int id) {
        return goalRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Goal not found with id: " + id));
    }

    public void deleteGoalById(int id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Goal not found with id: " + id);
        }
    }

    public GoalModel updateGoal(GoalModel updatedGoal) {
        if (goalRepository.existsById(updatedGoal.getId())) {
            return goalRepository.save(updatedGoal);
        } else {
            throw new NoEntityFoundException("Goal not found with id: " + updatedGoal.getId());
        }
    }
}

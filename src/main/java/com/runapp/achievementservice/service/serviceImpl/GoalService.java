package com.runapp.achievementservice.service.serviceImpl;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalService implements com.runapp.achievementservice.service.GoalService {
    private final GoalRepository goalRepository;

    @Override
    public GoalModel add(GoalModel entity) {
        return goalRepository.save(entity);
    }

    @Override
    public GoalModel getById(Long id) {
        return goalRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Goal not found with id: " + id));
    }

    @Override
    public List<GoalModel> getAll() {
        return goalRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Goal not found with id: " + id);
        }
    }

    @Override
    public GoalModel update(GoalModel entity) {
        if (goalRepository.existsById(entity.getId())) {
            return goalRepository.save(entity);
        } else {
            throw new NoEntityFoundException("Goal not found with id: " + entity.getId());
        }
    }
}

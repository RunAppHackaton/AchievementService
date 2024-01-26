package com.runapp.achievementservice.service.serviceImpl;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.util.supportClasses.UserExistHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalServiceImpl implements com.runapp.achievementservice.service.GoalService {

    private final GoalRepository goalRepository;
    private final UserExistHandler userExistHandler;
    private static final Logger LOGGER = LoggerFactory.getLogger(GoalServiceImpl.class);

    @Override
    public GoalModel add(GoalModel entity) {
        LOGGER.info("Goal add: {}", entity);
        userExistHandler.checkUserExist(entity.getUserId());
        return goalRepository.save(entity);
    }

    @Override
    public GoalModel getById(Long id) {
        LOGGER.info("Goal get by id: {}", id);
        return goalRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Goal not found with id: " + id));
    }

    @Override
    public List<GoalModel> getAll() {
        LOGGER.info("Goal get all");
        return goalRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("Goal delete by id: {}", id);
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Goal not found with id: " + id);
        }
    }

    @Override
    public GoalModel update(GoalModel entity) {
        LOGGER.info("Goal update: {}", entity);
        userExistHandler.checkUserExist(entity.getUserId());
        if (goalRepository.existsById(entity.getId())) {
            return goalRepository.save(entity);
        } else {
            throw new NoEntityFoundException("Goal not found with id: " + entity.getId());
        }
    }
}

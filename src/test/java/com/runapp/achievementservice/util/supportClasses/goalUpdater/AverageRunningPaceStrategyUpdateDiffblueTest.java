package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class AverageRunningPaceStrategyUpdateDiffblueTest {
    @Mock
    private GoalRepository goalRepository;

    @Mock
    private UserStatisticRepository achievementRepository;

    @InjectMocks
    private AverageRunningPaceStrategyUpdate updateStrategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void updateGoal_CurrentPaceLessThanGoal_SavesFinishedGoal() {
        GoalModel goalModel = new GoalModel();
        goalModel.setUserId(1L);
        goalModel.setGoal("PT4M"); // 4 minutes
        UserStatisticModel userProgress = new UserStatisticModel();
        userProgress.setAveragePaceRecord(Duration.ofMinutes(5)); // 5 minutes

        when(achievementRepository.findById(goalModel.getUserId())).thenReturn(Optional.of(userProgress));

        updateStrategy.updateGoal(goalModel, new ArrayList<>());

        verify(goalRepository, times(1)).save(goalModel);
    }

    @Test
    void updateGoal_CurrentPaceGreaterThanGoal_SavesUpdatedGoalWithCompletionPercentage() {
        GoalModel goalModel = new GoalModel();
        goalModel.setUserId(1L);
        goalModel.setGoal("PT5M"); // 5 minutes
        UserStatisticModel userProgress = new UserStatisticModel();
        userProgress.setAveragePaceRecord(Duration.ofMinutes(4)); // 4 minutes

        when(achievementRepository.findById(goalModel.getUserId())).thenReturn(Optional.of(userProgress));

        updateStrategy.updateGoal(goalModel, new ArrayList<>());

        verify(goalRepository, times(1)).save(goalModel);
        assertEquals(80f, goalModel.getCompletionPercentage()); // 4/5 * 100 = 80%
    }

    @Test
    void updateGoal_UserProgressNotFound_SavesGoalWithoutCompletionPercentage() {
        GoalModel goalModel = new GoalModel();
        goalModel.setUserId(1L);
        goalModel.setGoal("PT5M"); // 5 minutes

        when(achievementRepository.findById(goalModel.getUserId())).thenReturn(Optional.empty());

        updateStrategy.updateGoal(goalModel, new ArrayList<>());

        verify(goalRepository, times(1)).save(goalModel);
        assertEquals(goalModel.getCompletionPercentage(), 0);
    }
}

package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TotalNumberTrainingStrategyUpdate.class})
@ExtendWith(SpringExtension.class)
class TotalNumberTrainingStrategyUpdateDiffblueTest {
    @MockBean
    private GoalRepository goalRepository;

    @Autowired
    private TotalNumberTrainingStrategyUpdate totalNumberTrainingStrategyUpdate;

    @MockBean
    private UserStatisticRepository userStatisticRepository;

    /**
     * Method under test:
     * {@link TotalNumberTrainingStrategyUpdate#updateGoal(GoalModel, List)}
     */
    @Test
    void testUpdateGoal() {
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel goalModel = new GoalModel();
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setId(1L);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId(1L);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel);

        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);
        Optional<UserStatisticModel> ofResult = Optional.of(userStatisticModel);
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        GoalStatusModel goalStatus2 = new GoalStatusModel();
        goalStatus2.setGoalModels(new ArrayList<>());
        goalStatus2.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType2 = new GoalTypeModel();
        goalType2.setGoalModels(new ArrayList<>());
        goalType2.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel model = new GoalModel();
        model.setCompletionPercentage(10.0f);
        model.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setGoal("42");
        model.setGoalStatus(goalStatus2);
        model.setGoalType(goalType2);
        model.setId(1L);
        model.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setUserId(1L);
        totalNumberTrainingStrategyUpdate.updateGoal(model, new ArrayList<>());
        verify(userStatisticRepository).findById(Mockito.<Long>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertEquals(4200.0f, model.getCompletionPercentage());
    }
}

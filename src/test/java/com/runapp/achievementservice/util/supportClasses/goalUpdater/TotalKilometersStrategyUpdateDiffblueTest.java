package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TotalKilometersStrategyUpdate.class})
@ExtendWith(SpringExtension.class)
class TotalKilometersStrategyUpdateDiffblueTest {
    @MockBean
    private GoalRepository goalRepository;

    @Autowired
    private TotalKilometersStrategyUpdate totalKilometersStrategyUpdate;

    /**
     * Method under test:
     * {@link TotalKilometersStrategyUpdate#updateGoal(GoalModel, List)}
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

        GoalStatusModel goalStatus2 = new GoalStatusModel();
        goalStatus2.setGoalModels(new ArrayList<>());
        goalStatus2.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType2 = new GoalTypeModel();
        goalType2.setGoalModels(new ArrayList<>());
        goalType2.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);
        GoalModel model = mock(GoalModel.class);
        when(model.getGoal()).thenReturn("42");
        doNothing().when(model).setCompletionPercentage(anyFloat());
        doNothing().when(model).setFinishedDate(Mockito.<LocalDateTime>any());
        doNothing().when(model).setGoal(Mockito.<String>any());
        doNothing().when(model).setGoalStatus(Mockito.<GoalStatusModel>any());
        doNothing().when(model).setGoalType(Mockito.<GoalTypeModel>any());
        doNothing().when(model).setId(Mockito.<Long>any());
        doNothing().when(model).setStartDate(Mockito.<LocalDateTime>any());
        doNothing().when(model).setUserId(Mockito.<Long>any());
        model.setCompletionPercentage(10.0f);
        model.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setGoal("Goal");
        model.setGoalStatus(goalStatus2);
        model.setGoalType(goalType2);
        model.setId(1L);
        model.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setUserId(1L);

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(42);
        trainingModel.setId(1L);
        trainingModel.setUserId(1L);

        ArrayList<TrainingModel> allTraining = new ArrayList<>();
        allTraining.add(trainingModel);
        totalKilometersStrategyUpdate.updateGoal(model, allTraining);
        verify(model).getGoal();
        verify(model, atLeast(1)).setCompletionPercentage(anyFloat());
        verify(model, atLeast(1)).setFinishedDate(Mockito.<LocalDateTime>any());
        verify(model).setGoal(Mockito.<String>any());
        verify(model, atLeast(1)).setGoalStatus(Mockito.<GoalStatusModel>any());
        verify(model).setGoalType(Mockito.<GoalTypeModel>any());
        verify(model).setId(Mockito.<Long>any());
        verify(model).setStartDate(Mockito.<LocalDateTime>any());
        verify(model).setUserId(Mockito.<Long>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
    }
}

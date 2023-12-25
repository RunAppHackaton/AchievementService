package com.runapp.achievementservice.util.supportClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GoalMarkDiffblueTest {
    /**
     * Method under test: {@link GoalMark#finishGoal(GoalModel)}
     */
    @Test
    void testFinishGoal() {
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel model = new GoalModel();
        model.setCompletionPercentage(10.0f);
        model.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setGoal("Goal");
        model.setGoalStatus(goalStatus);
        model.setGoalType(goalType);
        model.setId(1L);
        model.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setUserId(1L);
        GoalModel actualFinishGoalResult = GoalMark.finishGoal(model);
        assertEquals(100.0f, actualFinishGoalResult.getCompletionPercentage());
        assertEquals(GoalStatusEnum.FINISHED, actualFinishGoalResult.getGoalStatus().getStatusEnum());
    }

    /**
     * Method under test: {@link GoalMark#finishGoal(GoalModel)}
     */
    @Test
    void testFinishGoal2() {
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);
        GoalModel model = mock(GoalModel.class);
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
        model.setGoalStatus(goalStatus);
        model.setGoalType(goalType);
        model.setId(1L);
        model.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setUserId(1L);
        GoalMark.finishGoal(model);
        verify(model, atLeast(1)).setCompletionPercentage(anyFloat());
        verify(model, atLeast(1)).setFinishedDate(Mockito.<LocalDateTime>any());
        verify(model).setGoal(Mockito.<String>any());
        verify(model, atLeast(1)).setGoalStatus(Mockito.<GoalStatusModel>any());
        verify(model).setGoalType(Mockito.<GoalTypeModel>any());
        verify(model).setId(Mockito.<Long>any());
        verify(model).setStartDate(Mockito.<LocalDateTime>any());
        verify(model).setUserId(Mockito.<Long>any());
    }
}

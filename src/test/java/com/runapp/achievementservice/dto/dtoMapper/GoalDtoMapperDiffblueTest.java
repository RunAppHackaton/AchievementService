package com.runapp.achievementservice.dto.dtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.dto.request.GoalRequest;
import com.runapp.achievementservice.dto.response.GoalResponse;
import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.staticObject.StaticGoal;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import com.runapp.achievementservice.util.goalHandler.GoalFactoryHandler;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

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

@ContextConfiguration(classes = {GoalDtoMapper.class, GoalRequest.class})
@ExtendWith(SpringExtension.class)
class GoalDtoMapperDiffblueTest {
    @MockBean
    private EntityManager entityManager;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private GoalDtoMapper goalDtoMapper;

    @MockBean
    private GoalFactoryHandler goalFactoryHandler;

    @Autowired
    private GoalRequest goalRequest;

    /**
     * Method under test: {@link GoalDtoMapper#toModel(GoalRequest)}
     */
    @Test
    void testToModel() {
        when(goalFactoryHandler.isValid(Mockito.<GoalTypeEnum>any(), Mockito.<String>any())).thenReturn(true);
        doNothing().when(entityManager).close();
        when(entityManager.isOpen()).thenReturn(true);
        when(entityManager.find(Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(null);
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        GoalModel actualToModelResult = goalDtoMapper.toModel(goalRequest);
        verify(goalFactoryHandler).isValid(Mockito.<GoalTypeEnum>any(), Mockito.<String>any());
        verify(entityManager, atLeast(1)).close();
        verify(entityManager, atLeast(1)).find(Mockito.<Class<Object>>any(), Mockito.<Object>any());
        verify(entityManager, atLeast(1)).isOpen();
        verify(entityManagerFactory, atLeast(1)).createEntityManager();
        assertNull(actualToModelResult.getGoalStatus());
        assertNull(actualToModelResult.getGoalType());
        assertNull(actualToModelResult.getUserId());
        assertNull(actualToModelResult.getGoal());
        assertEquals(0.0f, actualToModelResult.getCompletionPercentage());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toModel(GoalRequest)}
     */
    @Test
    void testToModel2() {
        when(goalFactoryHandler.isValid(Mockito.<GoalTypeEnum>any(), Mockito.<String>any())).thenReturn(true);
        doThrow(new NoEntityFoundException("An error occurred")).when(entityManager).close();
        when(entityManager.isOpen()).thenReturn(true);
        when(entityManager.find(Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(null);
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        GoalModel actualToModelResult = goalDtoMapper.toModel(goalRequest);
        verify(goalFactoryHandler).isValid(Mockito.<GoalTypeEnum>any(), Mockito.<String>any());
        verify(entityManager, atLeast(1)).close();
        verify(entityManager, atLeast(1)).find(Mockito.<Class<Object>>any(), Mockito.<Object>any());
        verify(entityManager, atLeast(1)).isOpen();
        verify(entityManagerFactory, atLeast(1)).createEntityManager();
        assertNull(actualToModelResult.getGoalStatus());
        assertNull(actualToModelResult.getGoalType());
        assertNull(actualToModelResult.getUserId());
        assertNull(actualToModelResult.getGoal());
        assertEquals(0.0f, actualToModelResult.getCompletionPercentage());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponse(GoalModel)}
     */
    @Test
    void testToResponse() {
        GoalModel goalModel = StaticGoal.goalModel1();
        GoalResponse actualToResponseResult = goalDtoMapper.toResponse(goalModel);
        assertEquals("00:00", actualToResponseResult.getStartDate().toLocalTime().toString());
        assertEquals("1970-01-01", actualToResponseResult.getFinishedDate().toLocalDate().toString());
        assertEquals("Goal", actualToResponseResult.getGoal());
        assertEquals(10.0f, actualToResponseResult.getCompletionPercentage());
        assertEquals(1L, actualToResponseResult.getId().longValue());
        assertEquals("1", actualToResponseResult.getUserId());
        assertEquals(GoalStatusEnum.IN_PROGRESS, actualToResponseResult.getGoal_status());
        assertEquals(GoalTypeEnum.TOTAL_TRAINING_TIME, actualToResponseResult.getGoal_type());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponse(GoalModel)}
     */
    @Test
    void testToResponse2() {
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalTypeModel goalTypeModel = new GoalTypeModel();
        goalTypeModel.setGoalModels(new ArrayList<>());
        goalTypeModel.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalStatusModel goalStatusModel = new GoalStatusModel();
        goalStatusModel.setGoalModels(new ArrayList<>());
        goalStatusModel.setStatusEnum(GoalStatusEnum.IN_PROGRESS);
        GoalModel goalModel = mock(GoalModel.class);
        when(goalModel.getGoal()).thenReturn("Goal");
        when(goalModel.getFinishedDate()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(goalModel.getStartDate()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(goalModel.getGoalStatus()).thenReturn(goalStatusModel);
        when(goalModel.getGoalType()).thenReturn(goalTypeModel);
        when(goalModel.getCompletionPercentage()).thenReturn(10.0f);
        when(goalModel.getId()).thenReturn(1L);
        when(goalModel.getUserId()).thenReturn("1");
        doNothing().when(goalModel).setCompletionPercentage(anyFloat());
        doNothing().when(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setGoal(Mockito.<String>any());
        doNothing().when(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        doNothing().when(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        doNothing().when(goalModel).setId(Mockito.<Long>any());
        doNothing().when(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setUserId(Mockito.<String>any());
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setId(1L);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId("1");
        GoalResponse actualToResponseResult = goalDtoMapper.toResponse(goalModel);
        verify(goalModel).getCompletionPercentage();
        verify(goalModel).getFinishedDate();
        verify(goalModel).getGoal();
        verify(goalModel).getGoalStatus();
        verify(goalModel).getGoalType();
        verify(goalModel).getId();
        verify(goalModel).getStartDate();
        verify(goalModel).getUserId();
        verify(goalModel).setCompletionPercentage(anyFloat());
        verify(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setGoal(Mockito.<String>any());
        verify(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        verify(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        verify(goalModel).setId(Mockito.<Long>any());
        verify(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setUserId(Mockito.<String>any());
        assertEquals("00:00", actualToResponseResult.getStartDate().toLocalTime().toString());
        assertEquals("1970-01-01", actualToResponseResult.getFinishedDate().toLocalDate().toString());
        assertEquals("Goal", actualToResponseResult.getGoal());
        assertEquals(10.0f, actualToResponseResult.getCompletionPercentage());
        assertEquals(1L, actualToResponseResult.getId().longValue());
        assertEquals("1", actualToResponseResult.getUserId());
        assertEquals(GoalStatusEnum.IN_PROGRESS, actualToResponseResult.getGoal_status());
        assertEquals(GoalTypeEnum.TOTAL_TRAINING_TIME, actualToResponseResult.getGoal_type());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponse(GoalModel)}
     */
    @Test
    void testToResponse3() {
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalTypeModel goalTypeModel = new GoalTypeModel();
        goalTypeModel.setGoalModels(new ArrayList<>());
        goalTypeModel.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalStatusModel goalStatusModel = new GoalStatusModel();
        goalStatusModel.setGoalModels(new ArrayList<>());
        goalStatusModel.setStatusEnum(GoalStatusEnum.IN_PROGRESS);
        GoalModel goalModel = mock(GoalModel.class);
        when(goalModel.getStartDate()).thenThrow(new NoEntityFoundException("An error occurred"));
        when(goalModel.getGoalStatus()).thenReturn(goalStatusModel);
        when(goalModel.getGoalType()).thenReturn(goalTypeModel);
        when(goalModel.getCompletionPercentage()).thenReturn(10.0f);
        when(goalModel.getId()).thenReturn(1L);
        when(goalModel.getUserId()).thenReturn("1");
        doNothing().when(goalModel).setCompletionPercentage(anyFloat());
        doNothing().when(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setGoal(Mockito.<String>any());
        doNothing().when(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        doNothing().when(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        doNothing().when(goalModel).setId(Mockito.<Long>any());
        doNothing().when(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setUserId(Mockito.<String>any());
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setId(1L);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId("1");
        assertThrows(NoEntityFoundException.class, () -> goalDtoMapper.toResponse(goalModel));
        verify(goalModel).getCompletionPercentage();
        verify(goalModel).getGoalStatus();
        verify(goalModel).getGoalType();
        verify(goalModel).getId();
        verify(goalModel).getStartDate();
        verify(goalModel).getUserId();
        verify(goalModel).setCompletionPercentage(anyFloat());
        verify(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setGoal(Mockito.<String>any());
        verify(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        verify(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        verify(goalModel).setId(Mockito.<Long>any());
        verify(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setUserId(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList() {
        assertTrue(goalDtoMapper.toResponseList(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList2() {
        GoalModel goalModel = StaticGoal.goalModel1();

        ArrayList<GoalModel> goalModels = new ArrayList<>();
        goalModels.add(goalModel);
        assertEquals(1, goalDtoMapper.toResponseList(goalModels).size());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList3() {
        GoalModel goalModel = StaticGoal.goalModel1();

        GoalModel goalModel2 = StaticGoal.goalModel2();

        ArrayList<GoalModel> goalModels = new ArrayList<>();
        goalModels.add(goalModel2);
        goalModels.add(goalModel);
        assertEquals(2, goalDtoMapper.toResponseList(goalModels).size());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList4() {
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalTypeModel goalTypeModel = new GoalTypeModel();
        goalTypeModel.setGoalModels(new ArrayList<>());
        goalTypeModel.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalStatusModel goalStatusModel = new GoalStatusModel();
        goalStatusModel.setGoalModels(new ArrayList<>());
        goalStatusModel.setStatusEnum(GoalStatusEnum.IN_PROGRESS);
        GoalModel goalModel = mock(GoalModel.class);
        when(goalModel.getGoal()).thenReturn("Goal");
        when(goalModel.getFinishedDate()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(goalModel.getStartDate()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(goalModel.getGoalStatus()).thenReturn(goalStatusModel);
        when(goalModel.getGoalType()).thenReturn(goalTypeModel);
        when(goalModel.getCompletionPercentage()).thenReturn(10.0f);
        when(goalModel.getId()).thenReturn(1L);
        when(goalModel.getUserId()).thenReturn("1");
        doNothing().when(goalModel).setCompletionPercentage(anyFloat());
        doNothing().when(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setGoal(Mockito.<String>any());
        doNothing().when(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        doNothing().when(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        doNothing().when(goalModel).setId(Mockito.<Long>any());
        doNothing().when(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setUserId(Mockito.<String>any());
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setId(1L);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId("1");

        ArrayList<GoalModel> goalModels = new ArrayList<>();
        goalModels.add(goalModel);
        List<GoalResponse> actualToResponseListResult = goalDtoMapper.toResponseList(goalModels);
        verify(goalModel).getCompletionPercentage();
        verify(goalModel).getFinishedDate();
        verify(goalModel).getGoal();
        verify(goalModel).getGoalStatus();
        verify(goalModel).getGoalType();
        verify(goalModel).getId();
        verify(goalModel).getStartDate();
        verify(goalModel).getUserId();
        verify(goalModel).setCompletionPercentage(anyFloat());
        verify(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setGoal(Mockito.<String>any());
        verify(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        verify(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        verify(goalModel).setId(Mockito.<Long>any());
        verify(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setUserId(Mockito.<String>any());
        assertEquals(1, actualToResponseListResult.size());
    }

    /**
     * Method under test: {@link GoalDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList5() {
        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalTypeModel goalTypeModel = new GoalTypeModel();
        goalTypeModel.setGoalModels(new ArrayList<>());
        goalTypeModel.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalStatusModel goalStatusModel = new GoalStatusModel();
        goalStatusModel.setGoalModels(new ArrayList<>());
        goalStatusModel.setStatusEnum(GoalStatusEnum.IN_PROGRESS);
        GoalModel goalModel = mock(GoalModel.class);
        when(goalModel.getStartDate()).thenThrow(new NoEntityFoundException("An error occurred"));
        when(goalModel.getGoalStatus()).thenReturn(goalStatusModel);
        when(goalModel.getGoalType()).thenReturn(goalTypeModel);
        when(goalModel.getCompletionPercentage()).thenReturn(10.0f);
        when(goalModel.getId()).thenReturn(1L);
        when(goalModel.getUserId()).thenReturn("1");
        doNothing().when(goalModel).setCompletionPercentage(anyFloat());
        doNothing().when(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setGoal(Mockito.<String>any());
        doNothing().when(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        doNothing().when(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        doNothing().when(goalModel).setId(Mockito.<Long>any());
        doNothing().when(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setUserId(Mockito.<String>any());
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setId(1L);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId("1");

        ArrayList<GoalModel> goalModels = new ArrayList<>();
        goalModels.add(goalModel);
        assertThrows(NoEntityFoundException.class, () -> goalDtoMapper.toResponseList(goalModels));
        verify(goalModel).getCompletionPercentage();
        verify(goalModel).getGoalStatus();
        verify(goalModel).getGoalType();
        verify(goalModel).getId();
        verify(goalModel).getStartDate();
        verify(goalModel).getUserId();
        verify(goalModel).setCompletionPercentage(anyFloat());
        verify(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setGoal(Mockito.<String>any());
        verify(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        verify(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        verify(goalModel).setId(Mockito.<Long>any());
        verify(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        verify(goalModel).setUserId(Mockito.<String>any());
    }
}

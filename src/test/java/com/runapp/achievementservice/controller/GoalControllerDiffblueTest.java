package com.runapp.achievementservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.achievementservice.dto.dtoMapper.DtoMapper;
import com.runapp.achievementservice.dto.dtoMapper.GoalDtoMapper;
import com.runapp.achievementservice.dto.request.GoalRequest;
import com.runapp.achievementservice.dto.response.GoalResponse;
import com.runapp.achievementservice.feignClient.ProfileServiceClient;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.service.serviceImpl.GoalServiceImpl;
import com.runapp.achievementservice.staticObject.StaticGoal;
import com.runapp.achievementservice.staticObject.ToJson;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import com.runapp.achievementservice.util.goalHandler.GoalFactoryHandler;
import com.runapp.achievementservice.util.supportClasses.UserExistHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GoalController.class, GoalRequest.class})
@ExtendWith(SpringExtension.class)
class GoalControllerDiffblueTest {
    @Autowired
    private GoalRequest goalRequest;

    @MockBean
    private DtoMapper<GoalModel, GoalRequest, GoalResponse> dtoMapper;

    @Autowired
    private GoalController goalController;

    @MockBean
    private GoalServiceImpl goalServiceImpl;

    /**
     * Method under test: {@link GoalController#deleteGoal(long)}
     */
    @Test
    void testDeleteGoal() throws Exception {
        doNothing().when(goalServiceImpl).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/goals/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(goalController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link GoalController#updateGoal(long, GoalModel)}
     */
    @Test
    void testUpdateGoal() {
        GoalStatusModel goalStatus = mock(GoalStatusModel.class);
        doNothing().when(goalStatus).setGoalModels(Mockito.<List<GoalModel>>any());
        doNothing().when(goalStatus).setStatusEnum(Mockito.<GoalStatusEnum>any());
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);
        GoalTypeModel goalType = mock(GoalTypeModel.class);
        doNothing().when(goalType).setGoalModels(Mockito.<List<GoalModel>>any());
        doNothing().when(goalType).setGoalTypeEnum(Mockito.<GoalTypeEnum>any());
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalTypeModel goalTypeModel = StaticGoal.goalTypeModel1();

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
        when(goalModel.getUserId()).thenReturn(1L);
        doNothing().when(goalModel).setCompletionPercentage(anyFloat());
        doNothing().when(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setGoal(Mockito.<String>any());
        doNothing().when(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        doNothing().when(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        doNothing().when(goalModel).setId(Mockito.<Long>any());
        doNothing().when(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setUserId(Mockito.<Long>any());
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setId(1L);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId(1L);
        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel);
        when(goalRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        ProfileServiceClient profileServiceClient = mock(ProfileServiceClient.class);
        when(profileServiceClient.getUserById(Mockito.<Long>any())).thenReturn(null);
        GoalServiceImpl goalServiceImpl = new GoalServiceImpl(goalRepository, new UserExistHandler(profileServiceClient));

        GoalFactoryHandler goalFactoryHandler = new GoalFactoryHandler();
        GoalController goalController = new GoalController(goalServiceImpl,
                new GoalDtoMapper(goalFactoryHandler, new SessionDelegatorBaseImpl(null)));

        GoalModel updatedGoal = StaticGoal.goalModel1();
        ResponseEntity<GoalResponse> actualUpdateGoalResult = goalController.updateGoal(1L, updatedGoal);
        verify(profileServiceClient).getUserById(Mockito.<Long>any());
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
        verify(goalModel).setUserId(Mockito.<Long>any());
        verify(goalStatus).setGoalModels(Mockito.<List<GoalModel>>any());
        verify(goalStatus).setStatusEnum(Mockito.<GoalStatusEnum>any());
        verify(goalType).setGoalModels(Mockito.<List<GoalModel>>any());
        verify(goalType).setGoalTypeEnum(Mockito.<GoalTypeEnum>any());
        verify(goalRepository).existsById(Mockito.<Long>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        GoalResponse body = actualUpdateGoalResult.getBody();
        assertEquals("00:00", body.getFinishedDate().toLocalTime().toString());
        assertEquals("00:00", body.getStartDate().toLocalTime().toString());
        assertEquals("Goal", body.getGoal());
        assertEquals(10.0f, body.getCompletionPercentage());
        assertEquals(1L, body.getId().longValue());
        assertEquals(1L, body.getUserId().longValue());
        assertEquals(1L, updatedGoal.getId().longValue());
        assertEquals(200, actualUpdateGoalResult.getStatusCodeValue());
        assertEquals(GoalStatusEnum.IN_PROGRESS, body.getGoal_status());
        assertEquals(GoalTypeEnum.TOTAL_TRAINING_TIME, body.getGoal_type());
        assertTrue(actualUpdateGoalResult.hasBody());
        assertTrue(actualUpdateGoalResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link GoalController#updateGoal(long, GoalModel)}
     */
    @Test
    void testUpdateGoal2() {
        GoalStatusModel goalStatus = mock(GoalStatusModel.class);
        doNothing().when(goalStatus).setGoalModels(Mockito.<List<GoalModel>>any());
        doNothing().when(goalStatus).setStatusEnum(Mockito.<GoalStatusEnum>any());
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);
        GoalTypeModel goalType = mock(GoalTypeModel.class);
        doNothing().when(goalType).setGoalModels(Mockito.<List<GoalModel>>any());
        doNothing().when(goalType).setGoalTypeEnum(Mockito.<GoalTypeEnum>any());
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
        when(goalModel.getUserId()).thenReturn(1L);
        doNothing().when(goalModel).setCompletionPercentage(anyFloat());
        doNothing().when(goalModel).setFinishedDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setGoal(Mockito.<String>any());
        doNothing().when(goalModel).setGoalStatus(Mockito.<GoalStatusModel>any());
        doNothing().when(goalModel).setGoalType(Mockito.<GoalTypeModel>any());
        doNothing().when(goalModel).setId(Mockito.<Long>any());
        doNothing().when(goalModel).setStartDate(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel).setUserId(Mockito.<Long>any());
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setId(1L);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId(1L);
        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel);
        when(goalRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        UserExistHandler userExistHandler = mock(UserExistHandler.class);
        doNothing().when(userExistHandler).checkUserExist(Mockito.<Long>any());
        GoalServiceImpl goalServiceImpl = new GoalServiceImpl(goalRepository, userExistHandler);

        GoalFactoryHandler goalFactoryHandler = new GoalFactoryHandler();
        GoalController goalController = new GoalController(goalServiceImpl,
                new GoalDtoMapper(goalFactoryHandler, new SessionDelegatorBaseImpl(null)));

        GoalModel updatedGoal = StaticGoal.goalModel1();

        ResponseEntity<GoalResponse> actualUpdateGoalResult = goalController.updateGoal(1L, updatedGoal);
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
        verify(goalModel).setUserId(Mockito.<Long>any());
        verify(goalStatus).setGoalModels(Mockito.<List<GoalModel>>any());
        verify(goalStatus).setStatusEnum(Mockito.<GoalStatusEnum>any());
        verify(goalType).setGoalModels(Mockito.<List<GoalModel>>any());
        verify(goalType).setGoalTypeEnum(Mockito.<GoalTypeEnum>any());
        verify(userExistHandler).checkUserExist(Mockito.<Long>any());
        verify(goalRepository).existsById(Mockito.<Long>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        GoalResponse body = actualUpdateGoalResult.getBody();
        assertEquals("00:00", body.getFinishedDate().toLocalTime().toString());
        assertEquals("00:00", body.getStartDate().toLocalTime().toString());
        assertEquals("Goal", body.getGoal());
        assertEquals(10.0f, body.getCompletionPercentage());
        assertEquals(1L, body.getId().longValue());
        assertEquals(1L, body.getUserId().longValue());
        assertEquals(1L, updatedGoal.getId().longValue());
        assertEquals(200, actualUpdateGoalResult.getStatusCodeValue());
        assertEquals(GoalStatusEnum.IN_PROGRESS, body.getGoal_status());
        assertEquals(GoalTypeEnum.TOTAL_TRAINING_TIME, body.getGoal_type());
        assertTrue(actualUpdateGoalResult.hasBody());
        assertTrue(actualUpdateGoalResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link GoalController#updateGoal(long, GoalModel)}
     */
    @Test
    void testUpdateGoal3() {
        GoalModel goalModel = StaticGoal.goalModel1();
        GoalServiceImpl goalServiceImpl = mock(GoalServiceImpl.class);
        when(goalServiceImpl.update(Mockito.<GoalModel>any())).thenReturn(goalModel);
        GoalFactoryHandler goalFactoryHandler = new GoalFactoryHandler();
        GoalController goalController = new GoalController(goalServiceImpl,
                new GoalDtoMapper(goalFactoryHandler, new SessionDelegatorBaseImpl(null)));



        GoalModel updatedGoal = StaticGoal.goalModel1();
        ResponseEntity<GoalResponse> actualUpdateGoalResult = goalController.updateGoal(1L, updatedGoal);
        verify(goalServiceImpl).update(Mockito.<GoalModel>any());
        GoalResponse body = actualUpdateGoalResult.getBody();
        assertEquals("00:00", body.getFinishedDate().toLocalTime().toString());
        assertEquals("00:00", body.getStartDate().toLocalTime().toString());
        assertEquals("Goal", body.getGoal());
        assertEquals(10.0f, body.getCompletionPercentage());
        assertEquals(1L, body.getId().longValue());
        assertEquals(1L, body.getUserId().longValue());
        assertEquals(1L, updatedGoal.getId().longValue());
        assertEquals(200, actualUpdateGoalResult.getStatusCodeValue());
        assertEquals(GoalStatusEnum.IN_PROGRESS, body.getGoal_status());
        assertEquals(GoalTypeEnum.TOTAL_TRAINING_TIME, body.getGoal_type());
        assertTrue(actualUpdateGoalResult.hasBody());
        assertTrue(actualUpdateGoalResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link GoalController#deleteGoal(long)}
     */
    @Test
    void testDeleteGoal2() throws Exception {
        doNothing().when(goalServiceImpl).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/goals/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(goalController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link GoalController#getAllGoalStatusEnums()}
     */
    @Test
    void testGetAllGoalStatusEnums() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals/goal-status-enums");
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"IN_PROGRESS\",\"FINISHED\"]"));
    }

    /**
     * Method under test: {@link GoalController#getAllGoalStatusEnums()}
     */
    @Test
    void testGetAllGoalStatusEnums2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals/goal-status-enums",
                "Uri Variables");
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"IN_PROGRESS\",\"FINISHED\"]"));
    }

    /**
     * Method under test: {@link GoalController#getAllGoalStatusEnums()}
     */
    @Test
    void testGetAllGoalStatusEnums3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals/goal-status-enums");
        requestBuilder.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"IN_PROGRESS\",\"FINISHED\"]"));
    }

    /**
     * Method under test: {@link GoalController#getAllGoalTypeEnums()}
     */
    @Test
    void testGetAllGoalTypeEnums() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals/goal-type-enums");
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[\"TOTAL_TRAINING_TIME\",\"AVERAGE_RUNNING_PACE\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK\",\"TOTAL_NUMBER_OF"
                                        + "_WORKOUTS_IN_MONTH\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME\",\"TOTAL"
                                        + "_KILOMETERS\"]"));
    }

    /**
     * Method under test: {@link GoalController#getAllGoalTypeEnums()}
     */
    @Test
    void testGetAllGoalTypeEnums2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals/goal-type-enums",
                "Uri Variables");
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[\"TOTAL_TRAINING_TIME\",\"AVERAGE_RUNNING_PACE\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK\",\"TOTAL_NUMBER_OF"
                                        + "_WORKOUTS_IN_MONTH\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME\",\"TOTAL"
                                        + "_KILOMETERS\"]"));
    }

    /**
     * Method under test: {@link GoalController#getAllGoalTypeEnums()}
     */
    @Test
    void testGetAllGoalTypeEnums3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals/goal-type-enums");
        requestBuilder.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[\"TOTAL_TRAINING_TIME\",\"AVERAGE_RUNNING_PACE\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK\",\"TOTAL_NUMBER_OF"
                                        + "_WORKOUTS_IN_MONTH\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR\",\"TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME\",\"TOTAL"
                                        + "_KILOMETERS\"]"));
    }

    /**
     * Method under test: {@link GoalController#getAllGoals()}
     */
    @Test
    void testGetAllGoals() throws Exception {
        when(goalServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<GoalModel>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals");
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link GoalController#getGoalById(long)}
     */
    @Test
    void testGetGoalById() throws Exception {
        GoalModel goalModel = StaticGoal.goalModel1();
        when(goalServiceImpl.getById(Mockito.<Long>any())).thenReturn(goalModel);
        when(dtoMapper.toResponse(Mockito.<GoalModel>any())).thenReturn(new GoalResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals/{id}", 1L);
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(ToJson.asJsonString(new GoalResponse())));
    }

    /**
     * Method under test: {@link GoalController#saveGoal(GoalRequest)}
     */
    @Test
    void testSaveGoal() throws Exception {
        when(goalServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<GoalModel>>any())).thenReturn(new ArrayList<>());

        GoalRequest goalRequest2 = StaticGoal.goalRequest1();
        String content = (new ObjectMapper()).writeValueAsString(goalRequest2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/goals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(goalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

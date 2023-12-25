package com.runapp.achievementservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.achievementservice.dto.dtoMapper.DtoMapper;
import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.service.serviceImpl.TrainingServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TrainingController.class, TrainingRequest.class})
@ExtendWith(SpringExtension.class)
class TrainingControllerDiffblueTest {
    @Autowired
    private TrainingRequest trainingRequest;

    @MockBean
    private DtoMapper<TrainingModel, TrainingRequest, TrainingResponse> dtoMapper;

    @Autowired
    private TrainingController trainingController;

    @MockBean
    private TrainingServiceImpl trainingServiceImpl;

    /**
     * Method under test: {@link TrainingController#deleteTrainingById(Long)}
     */
    @Test
    void testDeleteTrainingById() throws Exception {
        doNothing().when(trainingServiceImpl).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/trainings/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(trainingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link TrainingController#getAllTrainingsByUserId(Long)}
     */
    @Test
    void testGetAllTrainingsByUserId() throws Exception {
        when(trainingServiceImpl.getAllTrainingsByUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<TrainingModel>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings/user/{userId}", 1L);
        MockMvcBuilders.standaloneSetup(trainingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TrainingController#deleteTrainingById(Long)}
     */
    @Test
    void testDeleteTrainingById2() throws Exception {
        doNothing().when(trainingServiceImpl).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/trainings/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(trainingController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link TrainingController#getAllTrainings()}
     */
    @Test
    void testGetAllTrainings() throws Exception {
        when(trainingServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<TrainingModel>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings");
        MockMvcBuilders.standaloneSetup(trainingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TrainingController#getTrainingById(Long)}
     */
    @Test
    void testGetTrainingById() throws Exception {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId(1L);
        when(trainingServiceImpl.getById(Mockito.<Long>any())).thenReturn(trainingModel);
        when(dtoMapper.toResponse(Mockito.<TrainingModel>any())).thenReturn(new TrainingResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings/{id}", 1L);
        MockMvcBuilders.standaloneSetup(trainingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"training_date\":null,\"distance_km\":0,\"training_duration\":null,\"pace\":null,\"userId\":null}"));
    }

    /**
     * Method under test: {@link TrainingController#saveTraining(TrainingRequest)}
     */
    @Test
    void testSaveTraining() throws Exception {
        when(trainingServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<TrainingModel>>any())).thenReturn(new ArrayList<>());

        TrainingRequest trainingRequest2 = new TrainingRequest();
        trainingRequest2.setDistance_km(1);
        trainingRequest2.setTraining_date(null);
        trainingRequest2.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(trainingRequest2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(trainingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

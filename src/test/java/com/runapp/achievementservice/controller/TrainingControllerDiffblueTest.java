package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.dto.dtoMapper.DtoMapper;
import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.service.serviceImpl.TrainingServiceImpl;
import com.runapp.achievementservice.staticObject.StaticTraining;
import com.runapp.achievementservice.staticObject.ToJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TrainingController.class, TrainingRequest.class})
@ExtendWith(SpringExtension.class)
class TrainingControllerDiffblueTest {

    @MockBean
    private DtoMapper<TrainingModel, TrainingRequest, TrainingResponse> dtoMapper;

    @Autowired
    private TrainingController trainingController;

    @MockBean
    private TrainingServiceImpl trainingServiceImpl;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(trainingController).build();
    }

    /**
     * Method under test: {@link TrainingController#deleteTrainingById(Long)}
     */
    @Test
    void testDeleteTrainingById() throws Exception {
        doNothing().when(trainingServiceImpl).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/trainings/{id}", 1L);
        mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link TrainingController#getAllTrainingsByUserId(Long)}
     */
    @Test
    void testGetAllTrainingsByUserId() throws Exception {
        when(trainingServiceImpl.getAllTrainingsByUserId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<TrainingModel>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings/user/{userId}", 1L);
        mockMvc
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
        mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link TrainingController#getAllTrainings()}
     */
    @Test
    void testGetAllTrainings() throws Exception {
        when(trainingServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<TrainingModel>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings");
        mockMvc
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
        TrainingModel trainingModel = StaticTraining.trainingModel1();
        when(trainingServiceImpl.getById(Mockito.<Long>any())).thenReturn(trainingModel);
        when(dtoMapper.toResponse(Mockito.<TrainingModel>any())).thenReturn(new TrainingResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings/{id}", 1L);
        mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(ToJson.asJsonString(new TrainingResponse())));
    }

    /**
     * Method under test: {@link TrainingController#saveTraining(TrainingRequest)}
     */
    @Test
    void testSaveTraining() throws Exception {
        when(trainingServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(dtoMapper.toResponseList(Mockito.<List<TrainingModel>>any())).thenReturn(new ArrayList<>());

        TrainingRequest trainingRequest2 = StaticTraining.trainingRequest();
        String content = ToJson.asJsonString(trainingRequest2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trainings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

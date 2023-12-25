package com.runapp.achievementservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.achievementservice.dto.request.RarityRequest;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.service.RarityService;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {RarityController.class})
@ExtendWith(SpringExtension.class)
class RarityControllerDiffblueTest {
    @Autowired
    private RarityController rarityController;

    @MockBean
    private RarityService rarityService;

    /**
     * Method under test: {@link RarityController#createRarity(RarityRequest)}
     */
    @Test
    void testCreateRarity() throws Exception {
        when(rarityService.getAll()).thenReturn(new ArrayList<>());

        RarityRequest rarityRequest = new RarityRequest();
        rarityRequest.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(rarityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rarities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(rarityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RarityController#deleteRarity(Long)}
     */
    @Test
    void testDeleteRarity() throws Exception {
        doNothing().when(rarityService).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/rarities/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(rarityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RarityController#deleteRarity(Long)}
     */
    @Test
    void testDeleteRarity2() throws Exception {
        doNothing().when(rarityService).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/rarities/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(rarityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RarityController#getAllRarities()}
     */
    @Test
    void testGetAllRarities() throws Exception {
        when(rarityService.getAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rarities");
        MockMvcBuilders.standaloneSetup(rarityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RarityController#getRarityById(Long)}
     */
    @Test
    void testGetRarityById() throws Exception {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        when(rarityService.getById(Mockito.<Long>any())).thenReturn(rarityModel);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rarities/{id}", 1L);
        MockMvcBuilders.standaloneSetup(rarityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link RarityController#updateRarity(Long, RarityRequest)}
     */
    @Test
    void testUpdateRarity() throws Exception {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        when(rarityService.update(Mockito.<RarityModel>any())).thenReturn(rarityModel);

        RarityRequest rarityRequest = new RarityRequest();
        rarityRequest.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(rarityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/rarities/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(rarityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\"}"));
    }
}

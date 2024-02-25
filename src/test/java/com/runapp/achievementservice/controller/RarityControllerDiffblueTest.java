package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.dto.request.RarityRequest;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.service.RarityService;
import com.runapp.achievementservice.staticObject.StaticRarity;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {RarityController.class})
@ExtendWith(SpringExtension.class)
class RarityControllerDiffblueTest {
    @Autowired
    private RarityController rarityController;

    @MockBean
    private RarityService rarityService;

    private MockMvc mockMvc;

    /**
     * Method under test: {@link RarityController#createRarity(RarityRequest)}
     */

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(rarityController).build();
    }

    @Test
    void testCreateRarity() throws Exception {
        when(rarityService.getAll()).thenReturn(new ArrayList<>());

        RarityRequest rarityRequest = StaticRarity.rarityRequest1();
        String content = ToJson.asJsonString(rarityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rarities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc
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
        ResultActions actualPerformResult = mockMvc
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
        ResultActions actualPerformResult = mockMvc
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
        mockMvc
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
        RarityModel rarityModel = StaticRarity.rarityModel1();
        when(rarityService.getById(Mockito.<Long>any())).thenReturn(rarityModel);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rarities/{id}", 1L);
        mockMvc
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
        RarityModel rarityModel = StaticRarity.rarityModel1();
        when(rarityService.update(Mockito.<RarityModel>any())).thenReturn(rarityModel);

        RarityRequest rarityRequest = new RarityRequest();
        rarityRequest.setName("Name");
        String content = ToJson.asJsonString(rarityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/rarities/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\"}"));
    }
}

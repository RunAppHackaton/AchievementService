package com.runapp.achievementservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.achievementservice.dto.request.AchievementDeleteRequest;
import com.runapp.achievementservice.dto.request.AchievementRequest;
import com.runapp.achievementservice.dto.request.DeleteStorageRequest;
import com.runapp.achievementservice.feignClient.StorageServiceClient;
import com.runapp.achievementservice.feignClient.StoryManagementServiceClient;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import com.runapp.achievementservice.repository.RarityRepository;
import com.runapp.achievementservice.service.serviceImpl.AchievementServiceImpl;
import com.runapp.achievementservice.service.serviceImpl.RarityServiceImpl;
import feign.FeignException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {AchievementController.class})
@ExtendWith(SpringExtension.class)
class AchievementControllerDiffblueTest {
    @Autowired
    private AchievementController achievementController;

    @MockBean
    private AchievementServiceImpl achievementServiceImpl;

    @MockBean
    private RarityServiceImpl rarityServiceImpl;

    @MockBean
    private StorageServiceClient storageServiceClient;

    @MockBean
    private StoryManagementServiceClient storyManagementServiceClient;

    /**
     * Method under test: {@link AchievementController#getAchievementById(int)}
     */
    @Test
    void testGetAchievementById() throws Exception {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1);
        Optional<AchievementModel> ofResult = Optional.of(achievementModel);
        when(achievementServiceImpl.getAchievementById(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements/{id}", 1);
        MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"story_id\":1,\"description\":\"The characteristics of someone or something\","
                                        + "\"achievementImageUrl\":\"https://example.org/example\",\"rarityModel\":{\"id\":1,\"name\":\"Name\"}}"));
    }

    /**
     * Method under test: {@link AchievementController#getAchievementById(int)}
     */
    @Test
    void testGetAchievementById2() throws Exception {
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementServiceImpl.getAchievementById(anyInt())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test:
     * {@link AchievementController#updateAchievement(int, AchievementRequest)}
     */
    @Test
    void testUpdateAchievement() throws Exception {
        when(storyManagementServiceClient.getStoryById(anyInt())).thenReturn(null);

        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        when(rarityServiceImpl.getById(Mockito.<Long>any())).thenReturn(rarityModel);

        RarityModel rarityModel2 = new RarityModel();
        rarityModel2.setAchievementModelList(new ArrayList<>());
        rarityModel2.setId(1L);
        rarityModel2.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel2);
        achievementModel.setStory_id(1);
        Optional<AchievementModel> ofResult = Optional.of(achievementModel);

        RarityModel rarityModel3 = new RarityModel();
        rarityModel3.setAchievementModelList(new ArrayList<>());
        rarityModel3.setId(1L);
        rarityModel3.setName("Name");

        AchievementModel achievementModel2 = new AchievementModel();
        achievementModel2.setAchievementImageUrl("https://example.org/example");
        achievementModel2.setDescription("The characteristics of someone or something");
        achievementModel2.setId(1);
        achievementModel2.setName("Name");
        achievementModel2.setRarityModel(rarityModel3);
        achievementModel2.setStory_id(1);
        when(achievementServiceImpl.updateAchievement(Mockito.<AchievementModel>any())).thenReturn(achievementModel2);
        when(achievementServiceImpl.getAchievementById(anyInt())).thenReturn(ofResult);

        AchievementRequest achievementRequest = new AchievementRequest();
        achievementRequest.setDescription("The characteristics of someone or something");
        achievementRequest.setName("Name");
        achievementRequest.setRarity_id(1L);
        achievementRequest.setStory_id(1);
        String content = (new ObjectMapper()).writeValueAsString(achievementRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/achievements/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"story_id\":1,\"description\":\"The characteristics of someone or something\","
                                        + "\"achievementImageUrl\":\"https://example.org/example\",\"rarityModel\":{\"id\":1,\"name\":\"Name\"}}"));
    }

    /**
     * Method under test:
     * {@link AchievementController#updateAchievement(int, AchievementRequest)}
     */
    @Test
    void testUpdateAchievement2() throws Exception {
        when(storyManagementServiceClient.getStoryById(anyInt())).thenReturn(null);

        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        when(rarityServiceImpl.getById(Mockito.<Long>any())).thenReturn(rarityModel);
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(achievementServiceImpl.updateAchievement(Mockito.<AchievementModel>any())).thenThrow(feignException);
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementServiceImpl.getAchievementById(anyInt())).thenReturn(emptyResult);

        AchievementRequest achievementRequest = new AchievementRequest();
        achievementRequest.setDescription("The characteristics of someone or something");
        achievementRequest.setName("Name");
        achievementRequest.setRarity_id(1L);
        achievementRequest.setStory_id(1);
        String content = (new ObjectMapper()).writeValueAsString(achievementRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/achievements/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("achievement with id 1 not found"));
    }

    /**
     * Method under test:
     * {@link AchievementController#createAchievement(AchievementRequest)}
     */
    @Test
    void testCreateAchievement() throws Exception {
        when(achievementServiceImpl.getAllAchievements()).thenReturn(new ArrayList<>());

        AchievementRequest achievementRequest = new AchievementRequest();
        achievementRequest.setDescription("The characteristics of someone or something");
        achievementRequest.setName("Name");
        achievementRequest.setRarity_id(1L);
        achievementRequest.setStory_id(1);
        String content = (new ObjectMapper()).writeValueAsString(achievementRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AchievementController#deleteAchievement(int)}
     */
    @Test
    void testDeleteAchievement() throws Exception {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1);
        Optional<AchievementModel> ofResult = Optional.of(achievementModel);
        doNothing().when(achievementServiceImpl).deleteAchievement(anyInt());
        when(achievementServiceImpl.getAchievementById(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/achievements/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link AchievementController#deleteAchievement(int)}
     */
    @Test
    void testDeleteAchievement2() throws Exception {
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        doThrow(feignException).when(achievementServiceImpl).deleteAchievement(anyInt());
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementServiceImpl.getAchievementById(anyInt())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/achievements/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test:
     * {@link AchievementController#getAchievementsByStoryId(int)}
     */
    @Test
    void testGetAchievementsByStoryId() throws Exception {
        when(achievementServiceImpl.getAchievementsByStoryId(anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements/by-story/{storyId}", 1);
        MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link AchievementController#uploadImage(MultipartFile, int)}
     */
    @Test
    void testUploadImage() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
        //   See https://diff.blue/R013 to resolve this issue.

        AchievementRepository achievementRepository = mock(AchievementRepository.class);
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        AchievementServiceImpl achievementServiceImpl = new AchievementServiceImpl(achievementRepository);
        StoryManagementServiceClient storyManagementServiceClient = mock(StoryManagementServiceClient.class);
        AchievementController achievementController = new AchievementController(storyManagementServiceClient,
                new RarityServiceImpl(mock(RarityRepository.class)), achievementServiceImpl);
        ResponseEntity<Object> actualUploadImageResult = achievementController
                .uploadImage(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 1);
        verify(achievementRepository).findById(Mockito.<Integer>any());
        assertEquals("Achievement with id 1 not found", actualUploadImageResult.getBody());
        assertEquals(404, actualUploadImageResult.getStatusCodeValue());
        assertTrue(actualUploadImageResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link AchievementController#deleteImage(AchievementDeleteRequest)}
     */
    @Test
    void testDeleteImage() throws Exception {
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(storageServiceClient.deleteFile(Mockito.<DeleteStorageRequest>any())).thenThrow(feignException);
        FeignException feignException2 = mock(FeignException.class);
        when(feignException2.getCause()).thenReturn(new Throwable());
        when(achievementServiceImpl.updateAchievement(Mockito.<AchievementModel>any())).thenThrow(feignException2);
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementServiceImpl.getAchievementById(anyInt())).thenReturn(emptyResult);

        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest();
        achievementDeleteRequest.setAchievement_id(1);
        achievementDeleteRequest.setFile_uri("File uri");
        String content = (new ObjectMapper()).writeValueAsString(achievementDeleteRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/achievements/delete-image")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Achievement with id 1 not found"));
    }

    /**
     * Method under test: {@link AchievementController#getAllRarities()}
     */
    @Test
    void testGetAllRarities() throws Exception {
        when(achievementServiceImpl.getAllAchievements()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements");
        MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

package com.runapp.achievementservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.achievementservice.dto.request.AchievementDeleteRequest;
import com.runapp.achievementservice.dto.request.AchievementRequest;
import com.runapp.achievementservice.dto.request.DeleteStorageRequest;
import com.runapp.achievementservice.dto.response.StorageServiceResponse;
import com.runapp.achievementservice.exception.AchievementNotFoundException;
import com.runapp.achievementservice.exception.GlobalExceptionHandler;
import com.runapp.achievementservice.feignClient.StorageServiceClient;
import com.runapp.achievementservice.feignClient.StoryManagementServiceClient;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.repository.AchievementRepository;
import com.runapp.achievementservice.repository.RarityRepository;
import com.runapp.achievementservice.service.serviceImpl.AchievementServiceImpl;
import com.runapp.achievementservice.service.serviceImpl.RarityServiceImpl;
import com.runapp.achievementservice.staticObject.StaticAchievement;
import com.runapp.achievementservice.staticObject.StaticRarity;
import com.runapp.achievementservice.staticObject.ToJson;
import feign.FeignException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
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

    private MockMvc mockMvc;

    /**
     * Method under test: {@link AchievementController#getAchievementById(Long)}
     */

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(achievementController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }
    @Test
    void testGetAchievementById() throws Exception {

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setStory_id(1L);
        Optional<AchievementModel> ofResult = Optional.of(achievementModel);
        when(achievementServiceImpl.getAchievementById(anyLong())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements/{id}", 1);
        mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content()
                        .string(
                                ToJson.asJsonString(achievementModel)));
    }

    /**
     * Method under test: {@link AchievementController#getAchievementById(Long)}
     */
    @Test
    void testGetAchievementById2() throws Exception {
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementServiceImpl.getAchievementById(anyLong())).thenReturn(emptyResult);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements/{id}", 1);
        ResultActions actualPerformResult = mockMvc.perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound());
    }

    /**
     * Method under test:
     * {@link AchievementController#updateAchievement(Long, AchievementRequest)}
     */
    @Test
    void testUpdateAchievement() throws Exception {
        when(storyManagementServiceClient.getStoryById(anyInt())).thenReturn(null);

        RarityModel rarityModel = StaticRarity.rarityModel1();
        when(rarityServiceImpl.getById(Mockito.<Long>any())).thenReturn(rarityModel);

        RarityModel rarityModel2 = new RarityModel();
        rarityModel2.setAchievementModelList(new ArrayList<>());
        rarityModel2.setId(1L);
        rarityModel2.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel2);
        achievementModel.setStory_id(1L);
        Optional<AchievementModel> ofResult = Optional.of(achievementModel);

        AchievementModel achievementModel2 = new AchievementModel();
        achievementModel2.setAchievementImageUrl("https://example.org/example");
        achievementModel2.setDescription("The characteristics of someone or something");
        achievementModel2.setId(1L);
        achievementModel2.setName("Name");
        achievementModel2.setRarityModel(rarityModel2);
        achievementModel2.setStory_id(1L);
        when(achievementServiceImpl.updateAchievement(Mockito.<AchievementModel>any())).thenReturn(achievementModel2);
        when(achievementServiceImpl.getAchievementById(anyLong())).thenReturn(ofResult);

        AchievementRequest achievementRequest = new AchievementRequest();
        achievementRequest.setDescription("The characteristics of someone or something");
        achievementRequest.setName("Name");
        achievementRequest.setRarity_id(1L);
        achievementRequest.setStory_id(1L);
        String content = (new ObjectMapper()).writeValueAsString(achievementRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/achievements/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content()
                        .string(ToJson.asJsonString(achievementModel2)));
    }

    /**
     * Method under test:
     * {@link AchievementController#updateAchievement(Long, AchievementRequest)}
     */
    @Test
    void testUpdateAchievement2() throws Exception {
        when(storyManagementServiceClient.getStoryById(anyInt())).thenReturn(null);

        RarityModel rarityModel = StaticRarity.rarityModel1();

        when(rarityServiceImpl.getById(Mockito.<Long>any())).thenReturn(rarityModel);
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(achievementServiceImpl.updateAchievement(Mockito.<AchievementModel>any())).thenThrow(feignException);
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementServiceImpl.getAchievementById(anyLong())).thenReturn(emptyResult);

        AchievementRequest achievementRequest = new AchievementRequest();
        achievementRequest.setDescription("The characteristics of someone or something");
        achievementRequest.setName("Name");
        achievementRequest.setRarity_id(1L);
        achievementRequest.setStory_id(1L);
        String content = (new ObjectMapper()).writeValueAsString(achievementRequest);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(achievementController)
                .setControllerAdvice(new GlobalExceptionHandler())  // Include the global exception handler
                .build();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/achievements/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = mockMvc.perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("achievement with id 1 not found"));
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
        achievementRequest.setStory_id(1L);
        String content = (new ObjectMapper()).writeValueAsString(achievementRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[]"));
    }

    /**
     * Method under test: {@link AchievementController#deleteAchievement(Long)}
     */
    @Test
    void testDeleteAchievement() throws Exception {

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setStory_id(1L);
        Optional<AchievementModel> ofResult = Optional.of(achievementModel);
        doNothing().when(achievementServiceImpl).deleteAchievement(anyLong());
        when(achievementServiceImpl.getAchievementById(anyLong())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/achievements/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(achievementController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(status().isNoContent());
    }

    /**
     * Method under test: {@link AchievementController#deleteAchievement(Long)}
     */
    @Test
    void testDeleteAchievement2() throws Exception {
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        doThrow(feignException).when(achievementServiceImpl).deleteAchievement(anyLong());
        Optional<AchievementModel> emptyResult = Optional.empty();
        when(achievementServiceImpl.getAchievementById(anyLong())).thenReturn(emptyResult);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(achievementController)
                .setControllerAdvice(new GlobalExceptionHandler())  // Include the global exception handler
                .build();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/achievements/{id}", 1);
        ResultActions actualPerformResult = mockMvc.perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound());
    }

    /**
     * Method under test:
     * {@link AchievementController#getAchievementsByStoryId(Long)}
     */
    @Test
    void testGetAchievementsByStoryId() throws Exception {
        when(achievementServiceImpl.getAchievementsByStoryId(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/achievements/by-story/{storyId}", 1);
        mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[]"));
    }

    @Test
    void testUploadImageSuccess() throws Exception {
        // Mock the behavior of your service methods
        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setId(1L);
        achievementModel.setAchievementImageUrl("https://example.com/image.jpg");
        when(achievementServiceImpl.getAchievementById(1L)).thenReturn(Optional.of(achievementModel));

        // Mock the behavior of your storage service client
        String fileUri = "https://example.com/image.jpg";
        when(storageServiceClient.uploadFile(any(MultipartFile.class), any(String.class)))
                .thenReturn(new StorageServiceResponse(fileUri));

        // Perform the request to upload an image
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.jpg", "image/jpeg", "AXAXAXAX".getBytes());
        mockMvc.perform(multipart("/achievements/upload-image")
                        .file(mockMultipartFile)
                        .param("achievement_id", "1"))
                .andExpect(status().isOk());

        // Verify that the service method was called with the correct argument
        verify(achievementServiceImpl).getAchievementById(1L);
    }

    /**
     * Method under test:
     * {@link AchievementController#uploadImage(MultipartFile, Long)}
     */
    @Test
    void testUploadImageNotFound() throws Exception {
        // Mock the behavior of your service method to throw AchievementNotFoundException
        when(achievementServiceImpl.getAchievementById(anyLong())).thenThrow(new AchievementNotFoundException("Achievement with id 1 not found"));

        // Perform the request to upload an image
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.jpg", "image/jpeg", "AXAXAXAX".getBytes());
        mockMvc.perform(multipart("/achievements/upload-image")
                        .file(mockMultipartFile)
                        .param("achievement_id", "1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Achievement with id 1 not found"));

        // Verify that the service method was called with the correct argument
        verify(achievementServiceImpl).getAchievementById(1L);
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
        when(achievementServiceImpl.getAchievementById(anyLong())).thenReturn(emptyResult);

        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest();
        achievementDeleteRequest.setAchievement_id(1L);
        achievementDeleteRequest.setFile_uri("File uri");
        String content = ToJson.asJsonString(achievementDeleteRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/achievements/delete-image")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(achievementController)
                .setControllerAdvice(new GlobalExceptionHandler())  // Include the global exception handler
                .build();
        ResultActions actualPerformResult = mockMvc.perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Achievement with id 1 not found"));
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
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[]"));
    }
}

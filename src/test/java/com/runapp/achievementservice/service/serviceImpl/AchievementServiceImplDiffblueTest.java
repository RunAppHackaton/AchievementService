package com.runapp.achievementservice.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.repository.AchievementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AchievementServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AchievementServiceImplDiffblueTest {
    @MockBean
    private AchievementRepository achievementRepository;

    @Autowired
    private AchievementServiceImpl achievementServiceImpl;

    /**
     * Method under test:
     * {@link AchievementServiceImpl#createAchievement(AchievementModel)}
     */
    @Test
    void testCreateAchievement() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1L);
        when(achievementRepository.save(Mockito.<AchievementModel>any())).thenReturn(achievementModel);

        RarityModel rarityModel2 = new RarityModel();
        rarityModel2.setAchievementModelList(new ArrayList<>());
        rarityModel2.setId(1L);
        rarityModel2.setName("Name");

        AchievementModel achievementModel2 = new AchievementModel();
        achievementModel2.setAchievementImageUrl("https://example.org/example");
        achievementModel2.setDescription("The characteristics of someone or something");
        achievementModel2.setId(1L);
        achievementModel2.setName("Name");
        achievementModel2.setRarityModel(rarityModel2);
        achievementModel2.setStory_id(1L);
        AchievementModel actualCreateAchievementResult = achievementServiceImpl.createAchievement(achievementModel2);
        verify(achievementRepository).save(Mockito.<AchievementModel>any());
        assertSame(achievementModel, actualCreateAchievementResult);
    }

    /**
     * Method under test:
     * {@link AchievementServiceImpl#createAchievement(AchievementModel)}
     */
    @Test
    void testCreateAchievement2() {
        when(achievementRepository.save(Mockito.<AchievementModel>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));

        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1L);
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.createAchievement(achievementModel));
        verify(achievementRepository).save(Mockito.<AchievementModel>any());
    }

    /**
     * Method under test: {@link AchievementServiceImpl#getAchievementById(Long)}
     */
    @Test
    void testGetAchievementById() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1L);
        Optional<AchievementModel> ofResult = Optional.of(achievementModel);
        when(achievementRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<AchievementModel> actualAchievementById = achievementServiceImpl.getAchievementById(1L);
        verify(achievementRepository).findById(Mockito.<Long>any());
        assertTrue(actualAchievementById.isPresent());
        assertSame(ofResult, actualAchievementById);
    }

    /**
     * Method under test: {@link AchievementServiceImpl#getAchievementById(Long)}
     */
    @Test
    void testGetAchievementById2() {
        when(achievementRepository.findById(Mockito.<Long>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.getAchievementById(1L));
        verify(achievementRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link AchievementServiceImpl#updateAchievement(AchievementModel)}
     */
    @Test
    void testUpdateAchievement() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1L);
        when(achievementRepository.save(Mockito.<AchievementModel>any())).thenReturn(achievementModel);
        when(achievementRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        RarityModel rarityModel2 = new RarityModel();
        rarityModel2.setAchievementModelList(new ArrayList<>());
        rarityModel2.setId(1L);
        rarityModel2.setName("Name");

        AchievementModel achievementModel2 = new AchievementModel();
        achievementModel2.setAchievementImageUrl("https://example.org/example");
        achievementModel2.setDescription("The characteristics of someone or something");
        achievementModel2.setId(1L);
        achievementModel2.setName("Name");
        achievementModel2.setRarityModel(rarityModel2);
        achievementModel2.setStory_id(1L);
        AchievementModel actualUpdateAchievementResult = achievementServiceImpl.updateAchievement(achievementModel2);
        verify(achievementRepository).existsById(Mockito.<Long>any());
        verify(achievementRepository).save(Mockito.<AchievementModel>any());
        assertSame(achievementModel, actualUpdateAchievementResult);
    }

    /**
     * Method under test:
     * {@link AchievementServiceImpl#updateAchievement(AchievementModel)}
     */
    @Test
    void testUpdateAchievement2() {
        when(achievementRepository.save(Mockito.<AchievementModel>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        when(achievementRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1L);
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.updateAchievement(achievementModel));
        verify(achievementRepository).existsById(Mockito.<Long>any());
        verify(achievementRepository).save(Mockito.<AchievementModel>any());
    }

    /**
     * Method under test:
     * {@link AchievementServiceImpl#updateAchievement(AchievementModel)}
     */
    @Test
    void testUpdateAchievement3() {
        when(achievementRepository.existsById(Mockito.<Long>any())).thenReturn(false);

        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setId(1L);
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1L);
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.updateAchievement(achievementModel));
        verify(achievementRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link AchievementServiceImpl#deleteAchievement(Long)}
     */
    @Test
    void testDeleteAchievement() {
        doNothing().when(achievementRepository).deleteById(Mockito.<Long>any());
        when(achievementRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        achievementServiceImpl.deleteAchievement(1L);
        verify(achievementRepository).deleteById(Mockito.<Long>any());
        verify(achievementRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link AchievementServiceImpl#deleteAchievement(Long)}
     */
    @Test
    void testDeleteAchievement2() {
        doThrow(new NoEntityFoundException("An error occurred")).when(achievementRepository)
                .deleteById(Mockito.<Long>any());
        when(achievementRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.deleteAchievement(1L));
        verify(achievementRepository).deleteById(Mockito.<Long>any());
        verify(achievementRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link AchievementServiceImpl#deleteAchievement(Long)}
     */
    @Test
    void testDeleteAchievement3() {
        when(achievementRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.deleteAchievement(1L));
        verify(achievementRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link AchievementServiceImpl#getAchievementsByStoryId(Long)}
     */
    @Test
    void testGetAchievementsByStoryId() {
        ArrayList<AchievementModel> achievementModelList = new ArrayList<>();
        when(achievementRepository.findByStory_id(anyLong())).thenReturn(achievementModelList);
        List<AchievementModel> actualAchievementsByStoryId = achievementServiceImpl.getAchievementsByStoryId(1L);
        verify(achievementRepository).findByStory_id(anyLong());
        assertTrue(actualAchievementsByStoryId.isEmpty());
        assertSame(achievementModelList, actualAchievementsByStoryId);
    }

    /**
     * Method under test:
     * {@link AchievementServiceImpl#getAchievementsByStoryId(Long)}
     */
    @Test
    void testGetAchievementsByStoryId2() {
        when(achievementRepository.findByStory_id(anyLong())).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.getAchievementsByStoryId(1L));
        verify(achievementRepository).findByStory_id(anyLong());
    }

    /**
     * Method under test: {@link AchievementServiceImpl#getAllAchievements()}
     */
    @Test
    void testGetAllAchievements() {
        ArrayList<AchievementModel> achievementModelList = new ArrayList<>();
        when(achievementRepository.findAll()).thenReturn(achievementModelList);
        List<AchievementModel> actualAllAchievements = achievementServiceImpl.getAllAchievements();
        verify(achievementRepository).findAll();
        assertTrue(actualAllAchievements.isEmpty());
        assertSame(achievementModelList, actualAllAchievements);
    }

    /**
     * Method under test: {@link AchievementServiceImpl#getAllAchievements()}
     */
    @Test
    void testGetAllAchievements2() {
        when(achievementRepository.findAll()).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> achievementServiceImpl.getAllAchievements());
        verify(achievementRepository).findAll();
    }
}

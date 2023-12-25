package com.runapp.achievementservice.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.repository.RarityRepository;

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

@ContextConfiguration(classes = {RarityServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RarityServiceImplDiffblueTest {
    @MockBean
    private RarityRepository rarityRepository;

    @Autowired
    private RarityServiceImpl rarityServiceImpl;

    /**
     * Method under test: {@link RarityServiceImpl#add(RarityModel)}
     */
    @Test
    void testAdd() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        when(rarityRepository.save(Mockito.<RarityModel>any())).thenReturn(rarityModel);

        RarityModel entity = new RarityModel();
        entity.setAchievementModelList(new ArrayList<>());
        entity.setId(1L);
        entity.setName("Name");
        RarityModel actualAddResult = rarityServiceImpl.add(entity);
        verify(rarityRepository).save(Mockito.<RarityModel>any());
        assertSame(rarityModel, actualAddResult);
    }

    /**
     * Method under test: {@link RarityServiceImpl#add(RarityModel)}
     */
    @Test
    void testAdd2() {
        when(rarityRepository.save(Mockito.<RarityModel>any())).thenThrow(new NoEntityFoundException("An error occurred"));

        RarityModel entity = new RarityModel();
        entity.setAchievementModelList(new ArrayList<>());
        entity.setId(1L);
        entity.setName("Name");
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.add(entity));
        verify(rarityRepository).save(Mockito.<RarityModel>any());
    }

    /**
     * Method under test: {@link RarityServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        Optional<RarityModel> ofResult = Optional.of(rarityModel);
        when(rarityRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        RarityModel actualById = rarityServiceImpl.getById(1L);
        verify(rarityRepository).findById(Mockito.<Long>any());
        assertSame(rarityModel, actualById);
    }

    /**
     * Method under test: {@link RarityServiceImpl#getById(Long)}
     */
    @Test
    void testGetById2() {
        Optional<RarityModel> emptyResult = Optional.empty();
        when(rarityRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.getById(1L));
        verify(rarityRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link RarityServiceImpl#getById(Long)}
     */
    @Test
    void testGetById3() {
        when(rarityRepository.findById(Mockito.<Long>any())).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.getById(1L));
        verify(rarityRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link RarityServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<RarityModel> rarityModelList = new ArrayList<>();
        when(rarityRepository.findAll()).thenReturn(rarityModelList);
        List<RarityModel> actualAll = rarityServiceImpl.getAll();
        verify(rarityRepository).findAll();
        assertTrue(actualAll.isEmpty());
        assertSame(rarityModelList, actualAll);
    }

    /**
     * Method under test: {@link RarityServiceImpl#getAll()}
     */
    @Test
    void testGetAll2() {
        when(rarityRepository.findAll()).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.getAll());
        verify(rarityRepository).findAll();
    }

    /**
     * Method under test: {@link RarityServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(rarityRepository).deleteById(Mockito.<Long>any());
        when(rarityRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        rarityServiceImpl.deleteById(1L);
        verify(rarityRepository).deleteById(Mockito.<Long>any());
        verify(rarityRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link RarityServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById2() {
        doThrow(new NoEntityFoundException("An error occurred")).when(rarityRepository).deleteById(Mockito.<Long>any());
        when(rarityRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.deleteById(1L));
        verify(rarityRepository).deleteById(Mockito.<Long>any());
        verify(rarityRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link RarityServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById3() {
        when(rarityRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.deleteById(1L));
        verify(rarityRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link RarityServiceImpl#update(RarityModel)}
     */
    @Test
    void testUpdate() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        when(rarityRepository.save(Mockito.<RarityModel>any())).thenReturn(rarityModel);
        when(rarityRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        RarityModel entity = new RarityModel();
        entity.setAchievementModelList(new ArrayList<>());
        entity.setId(1L);
        entity.setName("Name");
        RarityModel actualUpdateResult = rarityServiceImpl.update(entity);
        verify(rarityRepository).existsById(Mockito.<Long>any());
        verify(rarityRepository, atLeast(1)).save(Mockito.<RarityModel>any());
        assertSame(rarityModel, actualUpdateResult);
    }

    /**
     * Method under test: {@link RarityServiceImpl#update(RarityModel)}
     */
    @Test
    void testUpdate2() {
        when(rarityRepository.save(Mockito.<RarityModel>any())).thenThrow(new NoEntityFoundException("An error occurred"));
        when(rarityRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        RarityModel entity = new RarityModel();
        entity.setAchievementModelList(new ArrayList<>());
        entity.setId(1L);
        entity.setName("Name");
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.update(entity));
        verify(rarityRepository).existsById(Mockito.<Long>any());
        verify(rarityRepository).save(Mockito.<RarityModel>any());
    }

    /**
     * Method under test: {@link RarityServiceImpl#update(RarityModel)}
     */
    @Test
    void testUpdate3() {
        when(rarityRepository.existsById(Mockito.<Long>any())).thenReturn(false);

        RarityModel entity = new RarityModel();
        entity.setAchievementModelList(new ArrayList<>());
        entity.setId(1L);
        entity.setName("Name");
        assertThrows(NoEntityFoundException.class, () -> rarityServiceImpl.update(entity));
        verify(rarityRepository).existsById(Mockito.<Long>any());
    }
}

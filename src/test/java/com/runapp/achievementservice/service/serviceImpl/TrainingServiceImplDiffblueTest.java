package com.runapp.achievementservice.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.util.supportClasses.goalUpdater.GoalUpdater;

import java.time.LocalDate;
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

@ContextConfiguration(classes = {TrainingServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TrainingServiceImplDiffblueTest {
    @MockBean
    private GoalUpdater goalUpdater;

    @MockBean
    private TrainingRepository trainingRepository;

    @Autowired
    private TrainingServiceImpl trainingServiceImpl;

    @MockBean
    private UserStatisticServiceImpl userStatisticServiceImpl;

    /**
     * Method under test: {@link TrainingServiceImpl#add(TrainingModel)}
     */
    @Test
    void testAdd() {
        doNothing().when(goalUpdater).updateAllGoal(Mockito.<Long>any());

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId(1L);
        when(trainingRepository.save(Mockito.<TrainingModel>any())).thenReturn(trainingModel);
        doNothing().when(userStatisticServiceImpl).addTrainingInStatistic(Mockito.<TrainingModel>any());
        doNothing().when(userStatisticServiceImpl).startTrackingUserStatisticsIfNone(Mockito.<Long>any());

        TrainingModel training = new TrainingModel();
        training.setDateTraining(LocalDate.of(1970, 1, 1));
        training.setDistanceKm(1);
        training.setId(1L);
        training.setUserId(1L);
        TrainingModel actualAddResult = trainingServiceImpl.add(training);
        verify(userStatisticServiceImpl).addTrainingInStatistic(Mockito.<TrainingModel>any());
        verify(userStatisticServiceImpl).startTrackingUserStatisticsIfNone(Mockito.<Long>any());
        verify(goalUpdater).updateAllGoal(Mockito.<Long>any());
        verify(trainingRepository).save(Mockito.<TrainingModel>any());
        assertSame(trainingModel, actualAddResult);
    }

    /**
     * Method under test: {@link TrainingServiceImpl#add(TrainingModel)}
     */
    @Test
    void testAdd2() {
        doThrow(new NoEntityFoundException("An error occurred")).when(userStatisticServiceImpl)
                .startTrackingUserStatisticsIfNone(Mockito.<Long>any());

        TrainingModel training = new TrainingModel();
        training.setDateTraining(LocalDate.of(1970, 1, 1));
        training.setDistanceKm(1);
        training.setId(1L);
        training.setUserId(1L);
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.add(training));
        verify(userStatisticServiceImpl).startTrackingUserStatisticsIfNone(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        when(trainingRepository.findAll()).thenReturn(trainingModelList);
        List<TrainingModel> actualAll = trainingServiceImpl.getAll();
        verify(trainingRepository).findAll();
        assertTrue(actualAll.isEmpty());
        assertSame(trainingModelList, actualAll);
    }

    /**
     * Method under test: {@link TrainingServiceImpl#getAll()}
     */
    @Test
    void testGetAll2() {
        when(trainingRepository.findAll()).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.getAll());
        verify(trainingRepository).findAll();
    }

    /**
     * Method under test: {@link TrainingServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId(1L);
        Optional<TrainingModel> ofResult = Optional.of(trainingModel);
        when(trainingRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        TrainingModel actualById = trainingServiceImpl.getById(1L);
        verify(trainingRepository).findById(Mockito.<Long>any());
        assertSame(trainingModel, actualById);
    }

    /**
     * Method under test: {@link TrainingServiceImpl#getById(Long)}
     */
    @Test
    void testGetById2() {
        Optional<TrainingModel> emptyResult = Optional.empty();
        when(trainingRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.getById(1L));
        verify(trainingRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#getById(Long)}
     */
    @Test
    void testGetById3() {
        when(trainingRepository.findById(Mockito.<Long>any())).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.getById(1L));
        verify(trainingRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(trainingRepository).deleteById(Mockito.<Long>any());
        when(trainingRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        trainingServiceImpl.deleteById(1L);
        verify(trainingRepository).deleteById(Mockito.<Long>any());
        verify(trainingRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById2() {
        doThrow(new NoEntityFoundException("An error occurred")).when(trainingRepository).deleteById(Mockito.<Long>any());
        when(trainingRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.deleteById(1L));
        verify(trainingRepository).deleteById(Mockito.<Long>any());
        verify(trainingRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById3() {
        when(trainingRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.deleteById(1L));
        verify(trainingRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#update(TrainingModel)}
     */
    @Test
    void testUpdate() {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId(1L);
        when(trainingRepository.save(Mockito.<TrainingModel>any())).thenReturn(trainingModel);
        when(trainingRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        TrainingModel updatedTraining = new TrainingModel();
        updatedTraining.setDateTraining(LocalDate.of(1970, 1, 1));
        updatedTraining.setDistanceKm(1);
        updatedTraining.setId(1L);
        updatedTraining.setUserId(1L);
        TrainingModel actualUpdateResult = trainingServiceImpl.update(updatedTraining);
        verify(trainingRepository).existsById(Mockito.<Long>any());
        verify(trainingRepository).save(Mockito.<TrainingModel>any());
        assertSame(trainingModel, actualUpdateResult);
    }

    /**
     * Method under test: {@link TrainingServiceImpl#update(TrainingModel)}
     */
    @Test
    void testUpdate2() {
        when(trainingRepository.save(Mockito.<TrainingModel>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        when(trainingRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        TrainingModel updatedTraining = new TrainingModel();
        updatedTraining.setDateTraining(LocalDate.of(1970, 1, 1));
        updatedTraining.setDistanceKm(1);
        updatedTraining.setId(1L);
        updatedTraining.setUserId(1L);
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.update(updatedTraining));
        verify(trainingRepository).existsById(Mockito.<Long>any());
        verify(trainingRepository).save(Mockito.<TrainingModel>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#update(TrainingModel)}
     */
    @Test
    void testUpdate3() {
        when(trainingRepository.existsById(Mockito.<Long>any())).thenReturn(false);

        TrainingModel updatedTraining = new TrainingModel();
        updatedTraining.setDateTraining(LocalDate.of(1970, 1, 1));
        updatedTraining.setDistanceKm(1);
        updatedTraining.setId(1L);
        updatedTraining.setUserId(1L);
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.update(updatedTraining));
        verify(trainingRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainingServiceImpl#getAllTrainingsByUserId(Long)}
     */
    @Test
    void testGetAllTrainingsByUserId() {
        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        when(trainingRepository.findAllByUserId(Mockito.<Long>any())).thenReturn(trainingModelList);
        List<TrainingModel> actualAllTrainingsByUserId = trainingServiceImpl.getAllTrainingsByUserId(1L);
        verify(trainingRepository).findAllByUserId(Mockito.<Long>any());
        assertTrue(actualAllTrainingsByUserId.isEmpty());
        assertSame(trainingModelList, actualAllTrainingsByUserId);
    }

    /**
     * Method under test: {@link TrainingServiceImpl#getAllTrainingsByUserId(Long)}
     */
    @Test
    void testGetAllTrainingsByUserId2() {
        when(trainingRepository.findAllByUserId(Mockito.<Long>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> trainingServiceImpl.getAllTrainingsByUserId(1L));
        verify(trainingRepository).findAllByUserId(Mockito.<Long>any());
    }
}

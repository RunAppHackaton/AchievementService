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
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.supportClasses.TrainingObserver;

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

@ContextConfiguration(classes = {UserStatisticServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserStatisticServiceImplDiffblueTest {
    @MockBean
    private TrainingObserver trainingObserver;

    @MockBean
    private UserStatisticRepository userStatisticRepository;

    @Autowired
    private UserStatisticServiceImpl userStatisticServiceImpl;

    /**
     * Method under test: {@link UserStatisticServiceImpl#getAllProgress()}
     */
    @Test
    void testGetAllProgress() {
        ArrayList<UserStatisticModel> userStatisticModelList = new ArrayList<>();
        when(userStatisticRepository.findAll()).thenReturn(userStatisticModelList);
        List<UserStatisticModel> actualAllProgress = userStatisticServiceImpl.getAllProgress();
        verify(userStatisticRepository).findAll();
        assertTrue(actualAllProgress.isEmpty());
        assertSame(userStatisticModelList, actualAllProgress);
    }

    /**
     * Method under test: {@link UserStatisticServiceImpl#getAllProgress()}
     */
    @Test
    void testGetAllProgress2() {
        when(userStatisticRepository.findAll()).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.getAllProgress());
        verify(userStatisticRepository).findAll();
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#deleteTrackingUserStatistics(Long)}
     */
    @Test
    void testDeleteTrackingUserStatistics() {
        doNothing().when(userStatisticRepository).deleteById(Mockito.<Long>any());
        doNothing().when(trainingObserver).deleteObserverForUserAchievements(Mockito.<Long>any());
        userStatisticServiceImpl.deleteTrackingUserStatistics(1L);
        verify(trainingObserver).deleteObserverForUserAchievements(Mockito.<Long>any());
        verify(userStatisticRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#deleteTrackingUserStatistics(Long)}
     */
    @Test
    void testDeleteTrackingUserStatistics2() {
        doThrow(new NoEntityFoundException("An error occurred")).when(trainingObserver)
                .deleteObserverForUserAchievements(Mockito.<Long>any());
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.deleteTrackingUserStatistics(1L));
        verify(trainingObserver).deleteObserverForUserAchievements(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#getCurrentProgressById(Long)}
     */
    @Test
    void testGetCurrentProgressById() {
        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);
        Optional<UserStatisticModel> ofResult = Optional.of(userStatisticModel);
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        UserStatisticModel actualCurrentProgressById = userStatisticServiceImpl.getCurrentProgressById(1L);
        verify(userStatisticRepository).findById(Mockito.<Long>any());
        assertSame(userStatisticModel, actualCurrentProgressById);
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#getCurrentProgressById(Long)}
     */
    @Test
    void testGetCurrentProgressById2() {
        Optional<UserStatisticModel> emptyResult = Optional.empty();
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.getCurrentProgressById(1L));
        verify(userStatisticRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#getCurrentProgressById(Long)}
     */
    @Test
    void testGetCurrentProgressById3() {
        when(userStatisticRepository.findById(Mockito.<Long>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.getCurrentProgressById(1L));
        verify(userStatisticRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#updateProgress(UserStatisticModel)}
     */
    @Test
    void testUpdateProgress() {
        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);
        when(userStatisticRepository.save(Mockito.<UserStatisticModel>any())).thenReturn(userStatisticModel);
        when(userStatisticRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        UserStatisticModel updatedProgress = new UserStatisticModel();
        updatedProgress.setNumberOfTrainingSessionsOverTime(1L);
        updatedProgress.setNumberOfWorkoutsPerMonth(1L);
        updatedProgress.setNumberOfWorkoutsPerWeek(1L);
        updatedProgress.setNumberOfWorkoutsPerYear(1L);
        updatedProgress.setTotalNumberOfWorkoutsForAllTime(1L);
        updatedProgress.setUserId(1L);
        UserStatisticModel actualUpdateProgressResult = userStatisticServiceImpl.updateProgress(updatedProgress);
        verify(userStatisticRepository).existsById(Mockito.<Long>any());
        verify(userStatisticRepository).save(Mockito.<UserStatisticModel>any());
        assertSame(userStatisticModel, actualUpdateProgressResult);
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#updateProgress(UserStatisticModel)}
     */
    @Test
    void testUpdateProgress2() {
        when(userStatisticRepository.save(Mockito.<UserStatisticModel>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        when(userStatisticRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        UserStatisticModel updatedProgress = new UserStatisticModel();
        updatedProgress.setNumberOfTrainingSessionsOverTime(1L);
        updatedProgress.setNumberOfWorkoutsPerMonth(1L);
        updatedProgress.setNumberOfWorkoutsPerWeek(1L);
        updatedProgress.setNumberOfWorkoutsPerYear(1L);
        updatedProgress.setTotalNumberOfWorkoutsForAllTime(1L);
        updatedProgress.setUserId(1L);
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.updateProgress(updatedProgress));
        verify(userStatisticRepository).existsById(Mockito.<Long>any());
        verify(userStatisticRepository).save(Mockito.<UserStatisticModel>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#updateProgress(UserStatisticModel)}
     */
    @Test
    void testUpdateProgress3() {
        when(userStatisticRepository.existsById(Mockito.<Long>any())).thenReturn(false);

        UserStatisticModel updatedProgress = new UserStatisticModel();
        updatedProgress.setNumberOfTrainingSessionsOverTime(1L);
        updatedProgress.setNumberOfWorkoutsPerMonth(1L);
        updatedProgress.setNumberOfWorkoutsPerWeek(1L);
        updatedProgress.setNumberOfWorkoutsPerYear(1L);
        updatedProgress.setTotalNumberOfWorkoutsForAllTime(1L);
        updatedProgress.setUserId(1L);
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.updateProgress(updatedProgress));
        verify(userStatisticRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#startTrackingUserStatisticsIfNone(Long)}
     */
    @Test
    void testStartTrackingUserStatisticsIfNone() {
        when(userStatisticRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        userStatisticServiceImpl.startTrackingUserStatisticsIfNone(1L);
        verify(userStatisticRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#startTrackingUserStatisticsIfNone(Long)}
     */
    @Test
    void testStartTrackingUserStatisticsIfNone2() {
        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);

        UserStatisticModel userStatisticModel2 = new UserStatisticModel();
        userStatisticModel2.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel2.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel2.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel2.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel2.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel2.setUserId(1L);
        Optional<UserStatisticModel> ofResult = Optional.of(userStatisticModel2);
        when(userStatisticRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        when(userStatisticRepository.save(Mockito.<UserStatisticModel>any())).thenReturn(userStatisticModel);
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        doNothing().when(trainingObserver)
                .createNewObserverForUserGoals(Mockito.<Long>any(), Mockito.<UserStatisticModel>any());
        userStatisticServiceImpl.startTrackingUserStatisticsIfNone(1L);
        verify(trainingObserver).createNewObserverForUserGoals(Mockito.<Long>any(), Mockito.<UserStatisticModel>any());
        verify(userStatisticRepository).existsById(Mockito.<Long>any());
        verify(userStatisticRepository).findById(Mockito.<Long>any());
        verify(userStatisticRepository).save(Mockito.<UserStatisticModel>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#startTrackingUserStatisticsIfNone(Long)}
     */
    @Test
    void testStartTrackingUserStatisticsIfNone3() {
        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);
        when(userStatisticRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        when(userStatisticRepository.save(Mockito.<UserStatisticModel>any())).thenReturn(userStatisticModel);
        Optional<UserStatisticModel> emptyResult = Optional.empty();
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.startTrackingUserStatisticsIfNone(1L));
        verify(userStatisticRepository).existsById(Mockito.<Long>any());
        verify(userStatisticRepository).findById(Mockito.<Long>any());
        verify(userStatisticRepository).save(Mockito.<UserStatisticModel>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#startTrackingUserStatisticsIfNone(Long)}
     */
    @Test
    void testStartTrackingUserStatisticsIfNone4() {
        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);

        UserStatisticModel userStatisticModel2 = new UserStatisticModel();
        userStatisticModel2.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel2.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel2.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel2.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel2.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel2.setUserId(1L);
        Optional<UserStatisticModel> ofResult = Optional.of(userStatisticModel2);
        when(userStatisticRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        when(userStatisticRepository.save(Mockito.<UserStatisticModel>any())).thenReturn(userStatisticModel);
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        doThrow(new NoEntityFoundException("An error occurred")).when(trainingObserver)
                .createNewObserverForUserGoals(Mockito.<Long>any(), Mockito.<UserStatisticModel>any());
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.startTrackingUserStatisticsIfNone(1L));
        verify(trainingObserver).createNewObserverForUserGoals(Mockito.<Long>any(), Mockito.<UserStatisticModel>any());
        verify(userStatisticRepository).existsById(Mockito.<Long>any());
        verify(userStatisticRepository).findById(Mockito.<Long>any());
        verify(userStatisticRepository).save(Mockito.<UserStatisticModel>any());
    }

    /**
     * Method under test:
     * {@link UserStatisticServiceImpl#addTrainingInStatistic(TrainingModel)}
     */
    @Test
    void testAddTrainingInStatistic() {
        Optional<UserStatisticModel> emptyResult = Optional.empty();
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId(1L);
        assertThrows(NoEntityFoundException.class, () -> userStatisticServiceImpl.addTrainingInStatistic(trainingModel));
        verify(userStatisticRepository).findById(Mockito.<Long>any());
    }
}

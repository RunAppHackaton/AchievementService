package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.TrainingRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GoalUpdater.class})
@ExtendWith(SpringExtension.class)
class GoalUpdaterDiffblueTest {
    @MockBean
    private GoalRepository goalRepository;

    @Autowired
    private GoalUpdater goalUpdater;

    @MockBean
    private TrainingRepository trainingRepository;

    @MockBean
    private UserStatisticRepository userStatisticRepository;

    /**
     * Method under test: {@link GoalUpdater#updateAllGoal(Long)}
     */
    @Test
    void testUpdateAllGoal() {
        when(goalRepository.existsByUserId(Mockito.<Long>any())).thenReturn(true);
        goalUpdater.updateAllGoal(1L);
        verify(goalRepository).existsByUserId(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalUpdater#updateAllGoal(Long)}
     */
    @Test
    void testUpdateAllGoal2() {
        when(goalRepository.existsByUserId(Mockito.<Long>any())).thenReturn(false);
        when(trainingRepository.existsByUserId(Mockito.<Long>any())).thenReturn(true);
        goalUpdater.updateAllGoal(1L);
        verify(goalRepository).existsByUserId(Mockito.<Long>any());
        verify(trainingRepository).existsByUserId(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalUpdater#updateAllGoal(Long)}
     */
    @Test
    void testUpdateAllGoal3() {
        when(goalRepository.existsByUserId(Mockito.<Long>any())).thenReturn(false);
        when(trainingRepository.existsByUserId(Mockito.<Long>any())).thenReturn(false);
        when(trainingRepository.findAllByUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        assertThrows(NoEntityFoundException.class, () -> goalUpdater.updateAllGoal(1L));
        verify(goalRepository).existsByUserId(Mockito.<Long>any());
        verify(trainingRepository).existsByUserId(Mockito.<Long>any());
        verify(trainingRepository).findAllByUserId(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalUpdater#updateAllGoal(Long)}
     */
    @Test
    void testUpdateAllGoal4() {
        when(goalRepository.existsByUserId(Mockito.<Long>any())).thenReturn(false);
        when(trainingRepository.existsByUserId(Mockito.<Long>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> goalUpdater.updateAllGoal(1L));
        verify(goalRepository).existsByUserId(Mockito.<Long>any());
        verify(trainingRepository).existsByUserId(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalUpdater#updateAllGoal(Long)}
     */
    @Test
    void testUpdateAllGoal5() {
        when(goalRepository.findAllByUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(goalRepository.existsByUserId(Mockito.<Long>any())).thenReturn(false);

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(0);
        trainingModel.setId(2L);
        trainingModel.setUserId(2L);

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel);
        when(trainingRepository.existsByUserId(Mockito.<Long>any())).thenReturn(false);
        when(trainingRepository.findAllByUserId(Mockito.<Long>any())).thenReturn(trainingModelList);
        assertThrows(NoEntityFoundException.class, () -> goalUpdater.updateAllGoal(1L));
        verify(goalRepository).existsByUserId(Mockito.<Long>any());
        verify(goalRepository).findAllByUserId(Mockito.<Long>any());
        verify(trainingRepository).existsByUserId(Mockito.<Long>any());
        verify(trainingRepository).findAllByUserId(Mockito.<Long>any());
    }
}

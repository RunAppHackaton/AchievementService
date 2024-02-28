package com.runapp.achievementservice.util.supportClasses;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.service.serviceImpl.UserStatisticServiceImpl;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


class TrainingStatisticsUpdaterDiffblueTest {
    @Mock
    private UserStatisticServiceImpl userStatisticService;

    @InjectMocks
    private TrainingStatisticsUpdater statisticsUpdater;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testUpdateStatisticsByTrainingType() {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setUserId(1L);
        trainingModel.setDuration(Duration.ofSeconds(3600)); // 1 hour
        trainingModel.setAveragePace(Duration.ofMinutes(5)); // 5 minutes per kilometer
        trainingModel.setDistanceKm(10); // 10 kilometers

        UserStatisticModel statisticModel = new UserStatisticModel();
        when(userStatisticService.getCurrentProgressById(trainingModel.getUserId())).thenReturn(statisticModel);

        statisticsUpdater.updateStatisticsByTrainingType(trainingModel);

        // Verify that the statistics are updated correctly
        verify(userStatisticService).updateProgress(statisticModel);
    }
}

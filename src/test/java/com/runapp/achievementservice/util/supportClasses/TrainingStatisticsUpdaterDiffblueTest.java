package com.runapp.achievementservice.util.supportClasses;

import static org.mockito.Mockito.when;

import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.service.serviceImpl.UserStatisticServiceImpl;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrainingStatisticsUpdater.class})
@ExtendWith(SpringExtension.class)
class TrainingStatisticsUpdaterDiffblueTest {
    @Autowired
    private TrainingStatisticsUpdater trainingStatisticsUpdater;

    @MockBean
    private UserStatisticServiceImpl userStatisticServiceImpl;

    /**
     * Method under test:
     * {@link TrainingStatisticsUpdater#updateStatisticsByTrainingType(TrainingModel)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStatisticsByTrainingType() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.Duration.getSeconds()" because the return value of "com.runapp.achievementservice.model.TrainingModel.getDuration()" is null
        //       at com.runapp.achievementservice.util.supportClasses.TrainingStatisticsUpdater.updateStatisticsByTrainingType(TrainingStatisticsUpdater.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);
        when(userStatisticServiceImpl.getCurrentProgressById(Mockito.<Long>any())).thenReturn(userStatisticModel);

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId(1L);
        trainingStatisticsUpdater.updateStatisticsByTrainingType(trainingModel);
    }
}

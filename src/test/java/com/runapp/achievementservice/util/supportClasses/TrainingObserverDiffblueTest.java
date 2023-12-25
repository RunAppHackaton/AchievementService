package com.runapp.achievementservice.util.supportClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.UserStatisticRepository;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrainingObserver.class})
@ExtendWith(SpringExtension.class)
class TrainingObserverDiffblueTest {
    @MockBean
    private GoalScheduler goalScheduler;

    @Autowired
    private TrainingObserver trainingObserver;

    @MockBean
    private UserStatisticRepository userStatisticRepository;

    /**
     * Method under test:
     * {@link TrainingObserver#createNewObserverForUserGoals(Long, UserStatisticModel)}
     */
    @Test
    void testCreateNewObserverForUserGoals() {
        doNothing().when(goalScheduler)
                .scheduleTask(Mockito.<String>any(), Mockito.<Duration>any(), Mockito.<Runnable>any());

        UserStatisticModel model = new UserStatisticModel();
        model.setNumberOfTrainingSessionsOverTime(1L);
        model.setNumberOfWorkoutsPerMonth(1L);
        model.setNumberOfWorkoutsPerWeek(1L);
        model.setNumberOfWorkoutsPerYear(1L);
        model.setTotalNumberOfWorkoutsForAllTime(1L);
        model.setUserId(1L);
        trainingObserver.createNewObserverForUserGoals(1L, model);
        verify(goalScheduler, atLeast(1)).scheduleTask(Mockito.<String>any(), Mockito.<Duration>any(),
                Mockito.<Runnable>any());
        assertEquals(1L, model.getNumberOfTrainingSessionsOverTime().longValue());
        assertEquals(1L, model.getNumberOfWorkoutsPerMonth().longValue());
        assertEquals(1L, model.getNumberOfWorkoutsPerWeek().longValue());
        assertEquals(1L, model.getNumberOfWorkoutsPerYear().longValue());
        assertEquals(1L, model.getTotalNumberOfWorkoutsForAllTime().longValue());
        assertEquals(1L, model.getUserId().longValue());
    }

    /**
     * Method under test:
     * {@link TrainingObserver#deleteObserverForUserAchievements(Long)}
     */
    @Test
    void testDeleteObserverForUserAchievements() {
        doNothing().when(goalScheduler).cancelTask(Mockito.<String>any());
        trainingObserver.deleteObserverForUserAchievements(1L);
        verify(goalScheduler, atLeast(1)).cancelTask(Mockito.<String>any());
    }
}

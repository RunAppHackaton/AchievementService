package com.runapp.achievementservice.util.supportClasses;

import static org.mockito.Mockito.mock;

import java.time.Duration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GoalScheduler.class})
@ExtendWith(SpringExtension.class)
class GoalSchedulerDiffblueTest {
    @Autowired
    private GoalScheduler goalScheduler;

    @MockBean
    private TaskScheduler taskScheduler;

    /**
     * Method under test:
     * {@link GoalScheduler#scheduleTask(String, Duration, Runnable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testScheduleTask() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.Duration.toMinutes()" because "interval" is null
        //       at com.runapp.achievementservice.util.supportClasses.GoalScheduler.scheduleTask(GoalScheduler.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        goalScheduler.scheduleTask("Task Name", null, mock(Runnable.class));
    }

    /**
     * Method under test: {@link GoalScheduler#cancelTask(String)}
     */
    @Test
    void testCancelTask() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     GoalScheduler.scheduledTasks
        //     GoalScheduler.taskScheduler

        goalScheduler.cancelTask("Task Name");
    }
}

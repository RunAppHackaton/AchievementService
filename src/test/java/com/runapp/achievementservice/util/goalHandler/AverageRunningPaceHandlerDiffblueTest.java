package com.runapp.achievementservice.util.goalHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AverageRunningPaceHandler.class})
@ExtendWith(SpringExtension.class)
class AverageRunningPaceHandlerDiffblueTest {
    @Autowired
    private AverageRunningPaceHandler averageRunningPaceHandler;

    /**
     * Method under test: {@link AverageRunningPaceHandler#isValid(String)}
     */
    @Test
    void testIsValid() {
        assertFalse(averageRunningPaceHandler.isValid("Input"));
        assertTrue(averageRunningPaceHandler.isValid("9:09:09"));
    }
}

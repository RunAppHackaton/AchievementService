package com.runapp.achievementservice.util.goalHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TotalTrainingTimeHandler.class})
@ExtendWith(SpringExtension.class)
class TotalTrainingTimeHandlerDiffblueTest {
    @Autowired
    private TotalTrainingTimeHandler totalTrainingTimeHandler;

    /**
     * Method under test: {@link TotalTrainingTimeHandler#isValid(String)}
     */
    @Test
    void testIsValid() {
        assertFalse(totalTrainingTimeHandler.isValid("Input"));
        assertTrue(totalTrainingTimeHandler.isValid("9:09:09"));
    }
}

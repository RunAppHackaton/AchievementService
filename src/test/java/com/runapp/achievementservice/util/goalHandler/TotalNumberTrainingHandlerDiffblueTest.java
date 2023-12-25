package com.runapp.achievementservice.util.goalHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TotalNumberTrainingHandler.class})
@ExtendWith(SpringExtension.class)
class TotalNumberTrainingHandlerDiffblueTest {
    @Autowired
    private TotalNumberTrainingHandler totalNumberTrainingHandler;

    /**
     * Method under test: {@link TotalNumberTrainingHandler#isValid(String)}
     */
    @Test
    void testIsValid() {
        assertFalse(totalNumberTrainingHandler.isValid("Input"));
        assertTrue(totalNumberTrainingHandler.isValid("42"));
    }
}

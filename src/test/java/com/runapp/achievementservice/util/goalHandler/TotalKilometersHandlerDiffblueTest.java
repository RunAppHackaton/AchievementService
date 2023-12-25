package com.runapp.achievementservice.util.goalHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TotalKilometersHandler.class})
@ExtendWith(SpringExtension.class)
class TotalKilometersHandlerDiffblueTest {
    @Autowired
    private TotalKilometersHandler totalKilometersHandler;

    /**
     * Method under test: {@link TotalKilometersHandler#isValid(String)}
     */
    @Test
    void testIsValid() {
        assertFalse(totalKilometersHandler.isValid("Input"));
        assertTrue(totalKilometersHandler.isValid("42"));
    }
}

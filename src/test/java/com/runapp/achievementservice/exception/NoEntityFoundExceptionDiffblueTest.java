package com.runapp.achievementservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class NoEntityFoundExceptionDiffblueTest {
    /**
     * Method under test:
     * {@link NoEntityFoundException#NoEntityFoundException(String)}
     */
    @Test
    void testConstructor() {
        NoEntityFoundException actualNoEntityFoundException = new NoEntityFoundException("An error occurred");
        assertEquals("An error occurred", actualNoEntityFoundException.getLocalizedMessage());
        assertEquals("An error occurred", actualNoEntityFoundException.getMessage());
        assertNull(actualNoEntityFoundException.getCause());
        assertEquals(0, actualNoEntityFoundException.getSuppressed().length);
    }
}

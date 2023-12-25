package com.runapp.achievementservice.util.supportClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GoalCompletionCalculatorDiffblueTest {
    /**
     * Method under test:
     * {@link GoalCompletionCalculator#calculatePercentage(int, int)}
     */
    @Test
    void testCalculatePercentage() {
        assertEquals(100L, GoalCompletionCalculator.calculatePercentage(3, 3));
        assertEquals(0L, GoalCompletionCalculator.calculatePercentage(100, 3));
        assertEquals(300L, GoalCompletionCalculator.calculatePercentage(1, 3));
        assertThrows(ArithmeticException.class, () -> GoalCompletionCalculator.calculatePercentage(0, 3));
    }

    /**
     * Method under test:
     * {@link GoalCompletionCalculator#calculatePercentage(Duration, Duration)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCalculatePercentage2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.Duration.toMillis()" because "sumDurationAllTraining" is null
        //       at com.runapp.achievementservice.util.supportClasses.GoalCompletionCalculator.calculatePercentage(GoalCompletionCalculator.java:8)
        //   See https://diff.blue/R013 to resolve this issue.

        GoalCompletionCalculator.calculatePercentage(null, null);
    }
}

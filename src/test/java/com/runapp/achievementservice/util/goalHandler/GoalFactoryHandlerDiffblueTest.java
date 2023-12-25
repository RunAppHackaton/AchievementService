package com.runapp.achievementservice.util.goalHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GoalFactoryHandler.class})
@ExtendWith(SpringExtension.class)
class GoalFactoryHandlerDiffblueTest {
    @Autowired
    private GoalFactoryHandler goalFactoryHandler;

    /**
     * Method under test: {@link GoalFactoryHandler#isValid(GoalTypeEnum, String)}
     */
    @Test
    void testIsValid() {
        assertFalse(goalFactoryHandler.isValid(GoalTypeEnum.TOTAL_TRAINING_TIME, "Input"));
        assertFalse(goalFactoryHandler.isValid(GoalTypeEnum.AVERAGE_RUNNING_PACE, "Input"));
        assertFalse(goalFactoryHandler.isValid(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK, "Input"));
        assertFalse(goalFactoryHandler.isValid(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH, "Input"));
        assertTrue(goalFactoryHandler.isValid(GoalTypeEnum.TOTAL_TRAINING_TIME, "9:09:09"));
        assertFalse(goalFactoryHandler.isValid(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR, "Input"));
        assertFalse(goalFactoryHandler.isValid(GoalTypeEnum.TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME, "Input"));
        assertFalse(goalFactoryHandler.isValid(GoalTypeEnum.TOTAL_KILOMETERS, "Input"));
    }
}

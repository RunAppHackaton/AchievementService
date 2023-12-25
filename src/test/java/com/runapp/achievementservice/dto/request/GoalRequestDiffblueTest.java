package com.runapp.achievementservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GoalRequest.class})
@ExtendWith(SpringExtension.class)
class GoalRequestDiffblueTest {
    @Autowired
    private GoalRequest goalRequest;

    /**
     * Method under test: {@link GoalRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(goalRequest.canEqual("Other"));
        assertTrue(goalRequest.canEqual(goalRequest));
    }

    /**
     * Method under test: {@link GoalRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new GoalRequest(), null);
        assertNotEquals(new GoalRequest(), "Different type to GoalRequest");
        assertNotEquals(new GoalRequest(), 1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalRequest#equals(Object)}
     *   <li>{@link GoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        GoalRequest goalRequest = new GoalRequest();
        assertEquals(goalRequest, goalRequest);
        int expectedHashCodeResult = goalRequest.hashCode();
        assertEquals(expectedHashCodeResult, goalRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalRequest#equals(Object)}
     *   <li>{@link GoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        GoalRequest goalRequest = new GoalRequest();
        GoalRequest goalRequest2 = new GoalRequest();
        assertEquals(goalRequest, goalRequest2);
        int expectedHashCodeResult = goalRequest.hashCode();
        assertEquals(expectedHashCodeResult, goalRequest2.hashCode());
    }

    /**
     * Method under test: {@link GoalRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        GoalRequest goalRequest = new GoalRequest();
        goalRequest.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        assertNotEquals(goalRequest, new GoalRequest());
    }

    /**
     * Method under test: {@link GoalRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        GoalRequest goalRequest = new GoalRequest();
        goalRequest.setGoal("Goal");
        assertNotEquals(goalRequest, new GoalRequest());
    }

    /**
     * Method under test: {@link GoalRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        GoalRequest goalRequest = new GoalRequest();
        goalRequest.setUserId(1L);
        assertNotEquals(goalRequest, new GoalRequest());
    }

    /**
     * Method under test: {@link GoalRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        GoalRequest goalRequest = new GoalRequest();

        GoalRequest goalRequest2 = new GoalRequest();
        goalRequest2.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        assertNotEquals(goalRequest, goalRequest2);
    }

    /**
     * Method under test: {@link GoalRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        GoalRequest goalRequest = new GoalRequest();

        GoalRequest goalRequest2 = new GoalRequest();
        goalRequest2.setGoal("Goal");
        assertNotEquals(goalRequest, goalRequest2);
    }

    /**
     * Method under test: {@link GoalRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        GoalRequest goalRequest = new GoalRequest();

        GoalRequest goalRequest2 = new GoalRequest();
        goalRequest2.setUserId(1L);
        assertNotEquals(goalRequest, goalRequest2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalRequest#equals(Object)}
     *   <li>{@link GoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        GoalRequest goalRequest = new GoalRequest();
        goalRequest.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalRequest goalRequest2 = new GoalRequest();
        goalRequest2.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        assertEquals(goalRequest, goalRequest2);
        int expectedHashCodeResult = goalRequest.hashCode();
        assertEquals(expectedHashCodeResult, goalRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalRequest#equals(Object)}
     *   <li>{@link GoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        GoalRequest goalRequest = new GoalRequest();
        goalRequest.setGoal("Goal");

        GoalRequest goalRequest2 = new GoalRequest();
        goalRequest2.setGoal("Goal");
        assertEquals(goalRequest, goalRequest2);
        int expectedHashCodeResult = goalRequest.hashCode();
        assertEquals(expectedHashCodeResult, goalRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalRequest#equals(Object)}
     *   <li>{@link GoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        GoalRequest goalRequest = new GoalRequest();
        goalRequest.setUserId(1L);

        GoalRequest goalRequest2 = new GoalRequest();
        goalRequest2.setUserId(1L);
        assertEquals(goalRequest, goalRequest2);
        int expectedHashCodeResult = goalRequest.hashCode();
        assertEquals(expectedHashCodeResult, goalRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalRequest#setGoal(String)}
     *   <li>{@link GoalRequest#setGoal_type(GoalTypeEnum)}
     *   <li>{@link GoalRequest#setUserId(Long)}
     *   <li>{@link GoalRequest#toString()}
     *   <li>{@link GoalRequest#getGoal()}
     *   <li>{@link GoalRequest#getGoal_type()}
     *   <li>{@link GoalRequest#getUserId()}
     * </ul>
     */
    @Test
    void testSetGoal() {
        GoalRequest goalRequest = new GoalRequest();
        goalRequest.setGoal("Goal");
        goalRequest.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        goalRequest.setUserId(1L);
        String actualToStringResult = goalRequest.toString();
        String actualGoal = goalRequest.getGoal();
        GoalTypeEnum actualGoal_type = goalRequest.getGoal_type();
        assertEquals("Goal", actualGoal);
        assertEquals("GoalRequest(goal_type=TOTAL_TRAINING_TIME, goal=Goal, userId=1)", actualToStringResult);
        assertEquals(1L, goalRequest.getUserId().longValue());
        assertEquals(GoalTypeEnum.TOTAL_TRAINING_TIME, actualGoal_type);
    }
}

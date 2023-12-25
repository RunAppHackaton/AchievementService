package com.runapp.achievementservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GoalResponse.class})
@ExtendWith(SpringExtension.class)
class GoalResponseDiffblueTest {
    @Autowired
    private GoalResponse goalResponse;

    /**
     * Method under test: {@link GoalResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(goalResponse.canEqual("Other"));
        assertTrue(goalResponse.canEqual(goalResponse));
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new GoalResponse(), null);
        assertNotEquals(new GoalResponse(), "Different type to GoalResponse");
        assertNotEquals(new GoalResponse(), 1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        GoalResponse goalResponse = new GoalResponse();
        assertEquals(goalResponse, goalResponse);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        GoalResponse goalResponse = new GoalResponse();
        GoalResponse goalResponse2 = new GoalResponse();
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setId(1L);
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setUserId(1L);
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setCompletionPercentage(10.0f);
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setGoal_status(GoalStatusEnum.IN_PROGRESS);
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setGoal("Goal");
        assertNotEquals(goalResponse, new GoalResponse());
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        GoalResponse goalResponse = new GoalResponse();

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setId(1L);
        assertNotEquals(goalResponse, goalResponse2);
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals13() {
        GoalResponse goalResponse = new GoalResponse();

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setUserId(1L);
        assertNotEquals(goalResponse, goalResponse2);
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals14() {
        GoalResponse goalResponse = new GoalResponse();

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        assertNotEquals(goalResponse, goalResponse2);
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals15() {
        GoalResponse goalResponse = new GoalResponse();

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setGoal_status(GoalStatusEnum.IN_PROGRESS);
        assertNotEquals(goalResponse, goalResponse2);
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals16() {
        GoalResponse goalResponse = new GoalResponse();

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(goalResponse, goalResponse2);
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals17() {
        GoalResponse goalResponse = new GoalResponse();

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(goalResponse, goalResponse2);
    }

    /**
     * Method under test: {@link GoalResponse#equals(Object)}
     */
    @Test
    void testEquals18() {
        GoalResponse goalResponse = new GoalResponse();

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setGoal("Goal");
        assertNotEquals(goalResponse, goalResponse2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals19() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setId(1L);

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setId(1L);
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals20() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setUserId(1L);

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setUserId(1L);
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals21() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals22() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setGoal_status(GoalStatusEnum.IN_PROGRESS);

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setGoal_status(GoalStatusEnum.IN_PROGRESS);
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals23() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals24() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#equals(Object)}
     *   <li>{@link GoalResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals25() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setGoal("Goal");

        GoalResponse goalResponse2 = new GoalResponse();
        goalResponse2.setGoal("Goal");
        assertEquals(goalResponse, goalResponse2);
        int expectedHashCodeResult = goalResponse.hashCode();
        assertEquals(expectedHashCodeResult, goalResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoalResponse#setCompletionPercentage(float)}
     *   <li>{@link GoalResponse#setFinishedDate(LocalDateTime)}
     *   <li>{@link GoalResponse#setGoal(String)}
     *   <li>{@link GoalResponse#setGoal_status(GoalStatusEnum)}
     *   <li>{@link GoalResponse#setGoal_type(GoalTypeEnum)}
     *   <li>{@link GoalResponse#setId(Long)}
     *   <li>{@link GoalResponse#setStartDate(LocalDateTime)}
     *   <li>{@link GoalResponse#setUserId(Long)}
     *   <li>{@link GoalResponse#toString()}
     *   <li>{@link GoalResponse#getCompletionPercentage()}
     *   <li>{@link GoalResponse#getFinishedDate()}
     *   <li>{@link GoalResponse#getGoal()}
     *   <li>{@link GoalResponse#getGoal_status()}
     *   <li>{@link GoalResponse#getGoal_type()}
     *   <li>{@link GoalResponse#getId()}
     *   <li>{@link GoalResponse#getStartDate()}
     *   <li>{@link GoalResponse#getUserId()}
     * </ul>
     */
    @Test
    void testSetCompletionPercentage() {
        GoalResponse goalResponse = new GoalResponse();
        goalResponse.setCompletionPercentage(10.0f);
        LocalDateTime finishedDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        goalResponse.setFinishedDate(finishedDate);
        goalResponse.setGoal("Goal");
        goalResponse.setGoal_status(GoalStatusEnum.IN_PROGRESS);
        goalResponse.setGoal_type(GoalTypeEnum.TOTAL_TRAINING_TIME);
        goalResponse.setId(1L);
        LocalDateTime startDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        goalResponse.setStartDate(startDate);
        goalResponse.setUserId(1L);
        String actualToStringResult = goalResponse.toString();
        float actualCompletionPercentage = goalResponse.getCompletionPercentage();
        LocalDateTime actualFinishedDate = goalResponse.getFinishedDate();
        String actualGoal = goalResponse.getGoal();
        GoalStatusEnum actualGoal_status = goalResponse.getGoal_status();
        GoalTypeEnum actualGoal_type = goalResponse.getGoal_type();
        Long actualId = goalResponse.getId();
        LocalDateTime actualStartDate = goalResponse.getStartDate();
        Long actualUserId = goalResponse.getUserId();
        assertEquals("Goal", actualGoal);
        assertEquals("GoalResponse(id=1, userId=1, completionPercentage=10.0, goal_type=TOTAL_TRAINING_TIME, goal_status=IN"
                + "_PROGRESS, startDate=1970-01-01T00:00, finishedDate=1970-01-01T00:00, goal=Goal)", actualToStringResult);
        assertEquals(10.0f, actualCompletionPercentage);
        assertEquals(1L, actualId.longValue());
        assertEquals(1L, actualUserId.longValue());
        assertEquals(GoalStatusEnum.IN_PROGRESS, actualGoal_status);
        assertEquals(GoalTypeEnum.TOTAL_TRAINING_TIME, actualGoal_type);
        assertSame(finishedDate, actualFinishedDate);
        assertSame(startDate, actualStartDate);
    }
}

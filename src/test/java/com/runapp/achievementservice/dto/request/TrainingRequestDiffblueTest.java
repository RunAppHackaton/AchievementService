package com.runapp.achievementservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrainingRequest.class})
@ExtendWith(SpringExtension.class)
class TrainingRequestDiffblueTest {
    @Autowired
    private TrainingRequest trainingRequest;

    /**
     * Method under test: {@link TrainingRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(trainingRequest.canEqual("Other"));
        assertTrue(trainingRequest.canEqual(trainingRequest));
    }

    /**
     * Method under test: {@link TrainingRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TrainingRequest(), null);
        assertNotEquals(new TrainingRequest(), "Different type to TrainingRequest");
        assertNotEquals(new TrainingRequest(), 1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingRequest#equals(Object)}
     *   <li>{@link TrainingRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TrainingRequest trainingRequest = new TrainingRequest();
        assertEquals(trainingRequest, trainingRequest);
        int expectedHashCodeResult = trainingRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingRequest#equals(Object)}
     *   <li>{@link TrainingRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TrainingRequest trainingRequest = new TrainingRequest();
        TrainingRequest trainingRequest2 = new TrainingRequest();
        assertEquals(trainingRequest, trainingRequest2);
        int expectedHashCodeResult = trainingRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingRequest2.hashCode());
    }

    /**
     * Method under test: {@link TrainingRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        TrainingRequest trainingRequest = new TrainingRequest();
        trainingRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        assertNotEquals(trainingRequest, new TrainingRequest());
    }

    /**
     * Method under test: {@link TrainingRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        TrainingRequest trainingRequest = new TrainingRequest();
        trainingRequest.setDistance_km(1);
        assertNotEquals(trainingRequest, new TrainingRequest());
    }

    /**
     * Method under test: {@link TrainingRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        TrainingRequest trainingRequest = new TrainingRequest();
        trainingRequest.setUserId("1");
        assertNotEquals(trainingRequest, new TrainingRequest());
    }

    /**
     * Method under test: {@link TrainingRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        TrainingRequest trainingRequest = new TrainingRequest();

        TrainingRequest trainingRequest2 = new TrainingRequest();
        trainingRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        assertNotEquals(trainingRequest, trainingRequest2);
    }

    /**
     * Method under test: {@link TrainingRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        TrainingRequest trainingRequest = new TrainingRequest();

        TrainingRequest trainingRequest2 = new TrainingRequest();
        trainingRequest2.setUserId("1");
        assertNotEquals(trainingRequest, trainingRequest2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingRequest#equals(Object)}
     *   <li>{@link TrainingRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        TrainingRequest trainingRequest = new TrainingRequest();
        trainingRequest.setTraining_date(LocalDate.of(1970, 1, 1));

        TrainingRequest trainingRequest2 = new TrainingRequest();
        trainingRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        assertEquals(trainingRequest, trainingRequest2);
        int expectedHashCodeResult = trainingRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingRequest#equals(Object)}
     *   <li>{@link TrainingRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        TrainingRequest trainingRequest = new TrainingRequest();
        trainingRequest.setUserId("1");

        TrainingRequest trainingRequest2 = new TrainingRequest();
        trainingRequest2.setUserId("1");
        assertEquals(trainingRequest, trainingRequest2);
        int expectedHashCodeResult = trainingRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingRequest#setDistance_km(int)}
     *   <li>{@link TrainingRequest#setPace(Duration)}
     *   <li>{@link TrainingRequest#setTraining_date(LocalDate)}
     *   <li>{@link TrainingRequest#setTraining_duration(Duration)}
     *   <li>{@link TrainingRequest#setUserId(Long)}
     *   <li>{@link TrainingRequest#toString()}
     *   <li>{@link TrainingRequest#getDistance_km()}
     *   <li>{@link TrainingRequest#getPace()}
     *   <li>{@link TrainingRequest#getTraining_date()}
     *   <li>{@link TrainingRequest#getTraining_duration()}
     *   <li>{@link TrainingRequest#getUserId()}
     * </ul>
     */
    @Test
    void testSetDistance_km() {
        TrainingRequest trainingRequest = new TrainingRequest();
        trainingRequest.setDistance_km(1);
        trainingRequest.setPace(null);
        LocalDate training_date = LocalDate.of(1970, 1, 1);
        trainingRequest.setTraining_date(training_date);
        trainingRequest.setTraining_duration(null);
        trainingRequest.setUserId("1");
        String actualToStringResult = trainingRequest.toString();
        int actualDistance_km = trainingRequest.getDistance_km();
        trainingRequest.getPace();
        LocalDate actualTraining_date = trainingRequest.getTraining_date();
        trainingRequest.getTraining_duration();
        assertEquals(
                "TrainingRequest(training_date=1970-01-01, distance_km=1, training_duration=null, pace=null," + " userId=1)",
                actualToStringResult);
        assertEquals(1, actualDistance_km);
        assertEquals("1", trainingRequest.getUserId());
        assertSame(training_date, actualTraining_date);
    }
}

package com.runapp.achievementservice.dto.response;

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

@ContextConfiguration(classes = {TrainingResponse.class})
@ExtendWith(SpringExtension.class)
class TrainingResponseDiffblueTest {
    @Autowired
    private TrainingResponse trainingResponse;

    /**
     * Method under test: {@link TrainingResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(trainingResponse.canEqual("Other"));
        assertTrue(trainingResponse.canEqual(trainingResponse));
    }

    /**
     * Method under test: {@link TrainingResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TrainingResponse(), null);
        assertNotEquals(new TrainingResponse(), "Different type to TrainingResponse");
        assertNotEquals(new TrainingResponse(), 1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingResponse#equals(Object)}
     *   <li>{@link TrainingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TrainingResponse trainingResponse = new TrainingResponse();
        assertEquals(trainingResponse, trainingResponse);
        int expectedHashCodeResult = trainingResponse.hashCode();
        assertEquals(expectedHashCodeResult, trainingResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingResponse#equals(Object)}
     *   <li>{@link TrainingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TrainingResponse trainingResponse = new TrainingResponse();
        TrainingResponse trainingResponse2 = new TrainingResponse();
        assertEquals(trainingResponse, trainingResponse2);
        int expectedHashCodeResult = trainingResponse.hashCode();
        assertEquals(expectedHashCodeResult, trainingResponse2.hashCode());
    }

    /**
     * Method under test: {@link TrainingResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        TrainingResponse trainingResponse = new TrainingResponse();
        trainingResponse.setTraining_date(LocalDate.of(1970, 1, 1));
        assertNotEquals(trainingResponse, new TrainingResponse());
    }

    /**
     * Method under test: {@link TrainingResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        TrainingResponse trainingResponse = new TrainingResponse();
        trainingResponse.setDistance_km(1);
        assertNotEquals(trainingResponse, new TrainingResponse());
    }

    /**
     * Method under test: {@link TrainingResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        TrainingResponse trainingResponse = new TrainingResponse();
        trainingResponse.setUserId("1");
        assertNotEquals(trainingResponse, new TrainingResponse());
    }

    /**
     * Method under test: {@link TrainingResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        TrainingResponse trainingResponse = new TrainingResponse();

        TrainingResponse trainingResponse2 = new TrainingResponse();
        trainingResponse2.setTraining_date(LocalDate.of(1970, 1, 1));
        assertNotEquals(trainingResponse, trainingResponse2);
    }

    /**
     * Method under test: {@link TrainingResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        TrainingResponse trainingResponse = new TrainingResponse();

        TrainingResponse trainingResponse2 = new TrainingResponse();
        trainingResponse2.setUserId("1");
        assertNotEquals(trainingResponse, trainingResponse2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingResponse#equals(Object)}
     *   <li>{@link TrainingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        TrainingResponse trainingResponse = new TrainingResponse();
        trainingResponse.setTraining_date(LocalDate.of(1970, 1, 1));

        TrainingResponse trainingResponse2 = new TrainingResponse();
        trainingResponse2.setTraining_date(LocalDate.of(1970, 1, 1));
        assertEquals(trainingResponse, trainingResponse2);
        int expectedHashCodeResult = trainingResponse.hashCode();
        assertEquals(expectedHashCodeResult, trainingResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingResponse#equals(Object)}
     *   <li>{@link TrainingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        TrainingResponse trainingResponse = new TrainingResponse();
        trainingResponse.setUserId("1");

        TrainingResponse trainingResponse2 = new TrainingResponse();
        trainingResponse2.setUserId("1");
        assertEquals(trainingResponse, trainingResponse2);
        int expectedHashCodeResult = trainingResponse.hashCode();
        assertEquals(expectedHashCodeResult, trainingResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingResponse#setDistance_km(int)}
     *   <li>{@link TrainingResponse#setPace(Duration)}
     *   <li>{@link TrainingResponse#setTraining_date(LocalDate)}
     *   <li>{@link TrainingResponse#setTraining_duration(Duration)}
     *   <li>{@link TrainingResponse#setUserId(Long)}
     *   <li>{@link TrainingResponse#toString()}
     *   <li>{@link TrainingResponse#getDistance_km()}
     *   <li>{@link TrainingResponse#getPace()}
     *   <li>{@link TrainingResponse#getTraining_date()}
     *   <li>{@link TrainingResponse#getTraining_duration()}
     *   <li>{@link TrainingResponse#getUserId()}
     * </ul>
     */
    @Test
    void testSetDistance_km() {
        TrainingResponse trainingResponse = new TrainingResponse();
        trainingResponse.setDistance_km(1);
        trainingResponse.setPace(null);
        LocalDate training_date = LocalDate.of(1970, 1, 1);
        trainingResponse.setTraining_date(training_date);
        trainingResponse.setTraining_duration(null);
        trainingResponse.setUserId("1");
        String actualToStringResult = trainingResponse.toString();
        int actualDistance_km = trainingResponse.getDistance_km();
        trainingResponse.getPace();
        LocalDate actualTraining_date = trainingResponse.getTraining_date();
        trainingResponse.getTraining_duration();
        assertEquals(
                "TrainingResponse(training_date=1970-01-01, distance_km=1, training_duration=null, pace=null," + " userId=1)",
                actualToStringResult);
        assertEquals(1, actualDistance_km);
        assertEquals("1", trainingResponse.getUserId());
        assertSame(training_date, actualTraining_date);
    }
}

package com.runapp.achievementservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AchievementDeleteRequest.class})
@ExtendWith(SpringExtension.class)
class AchievementDeleteRequestDiffblueTest {
    @Autowired
    private AchievementDeleteRequest achievementDeleteRequest;

    /**
     * Method under test: {@link AchievementDeleteRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(achievementDeleteRequest.canEqual("Other"));
        assertTrue(achievementDeleteRequest.canEqual(achievementDeleteRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AchievementDeleteRequest#AchievementDeleteRequest()}
     *   <li>{@link AchievementDeleteRequest#setAchievement_id(int)}
     *   <li>{@link AchievementDeleteRequest#setFile_uri(String)}
     *   <li>{@link AchievementDeleteRequest#toString()}
     *   <li>{@link AchievementDeleteRequest#getAchievement_id()}
     *   <li>{@link AchievementDeleteRequest#getFile_uri()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AchievementDeleteRequest actualAchievementDeleteRequest = new AchievementDeleteRequest();
        actualAchievementDeleteRequest.setAchievement_id(1);
        actualAchievementDeleteRequest.setFile_uri("File uri");
        String actualToStringResult = actualAchievementDeleteRequest.toString();
        int actualAchievement_id = actualAchievementDeleteRequest.getAchievement_id();
        assertEquals("AchievementDeleteRequest(file_uri=File uri, achievement_id=1)", actualToStringResult);
        assertEquals("File uri", actualAchievementDeleteRequest.getFile_uri());
        assertEquals(1, actualAchievement_id);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AchievementDeleteRequest#AchievementDeleteRequest(String, int)}
     *   <li>{@link AchievementDeleteRequest#setAchievement_id(int)}
     *   <li>{@link AchievementDeleteRequest#setFile_uri(String)}
     *   <li>{@link AchievementDeleteRequest#toString()}
     *   <li>{@link AchievementDeleteRequest#getAchievement_id()}
     *   <li>{@link AchievementDeleteRequest#getFile_uri()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        AchievementDeleteRequest actualAchievementDeleteRequest = new AchievementDeleteRequest("File uri", 1);
        actualAchievementDeleteRequest.setAchievement_id(1);
        actualAchievementDeleteRequest.setFile_uri("File uri");
        String actualToStringResult = actualAchievementDeleteRequest.toString();
        int actualAchievement_id = actualAchievementDeleteRequest.getAchievement_id();
        assertEquals("AchievementDeleteRequest(file_uri=File uri, achievement_id=1)", actualToStringResult);
        assertEquals("File uri", actualAchievementDeleteRequest.getFile_uri());
        assertEquals(1, actualAchievement_id);
    }

    /**
     * Method under test: {@link AchievementDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AchievementDeleteRequest("File uri", 1), null);
        assertNotEquals(new AchievementDeleteRequest("File uri", 1), "Different type to AchievementDeleteRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AchievementDeleteRequest#equals(Object)}
     *   <li>{@link AchievementDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest("File uri", 1);
        assertEquals(achievementDeleteRequest, achievementDeleteRequest);
        int expectedHashCodeResult = achievementDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, achievementDeleteRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AchievementDeleteRequest#equals(Object)}
     *   <li>{@link AchievementDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest("File uri", 1);
        AchievementDeleteRequest achievementDeleteRequest2 = new AchievementDeleteRequest("File uri", 1);

        assertEquals(achievementDeleteRequest, achievementDeleteRequest2);
        int expectedHashCodeResult = achievementDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, achievementDeleteRequest2.hashCode());
    }

    /**
     * Method under test: {@link AchievementDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest(null, 1);
        assertNotEquals(achievementDeleteRequest, new AchievementDeleteRequest("File uri", 1));
    }

    /**
     * Method under test: {@link AchievementDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest(
                "com.runapp.achievementservice.dto.request.AchievementDeleteRequest", 1);
        assertNotEquals(achievementDeleteRequest, new AchievementDeleteRequest("File uri", 1));
    }

    /**
     * Method under test: {@link AchievementDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest("File uri", 2);
        assertNotEquals(achievementDeleteRequest, new AchievementDeleteRequest("File uri", 1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AchievementDeleteRequest#equals(Object)}
     *   <li>{@link AchievementDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals7() {
        AchievementDeleteRequest achievementDeleteRequest = new AchievementDeleteRequest(null, 1);
        AchievementDeleteRequest achievementDeleteRequest2 = new AchievementDeleteRequest(null, 1);

        assertEquals(achievementDeleteRequest, achievementDeleteRequest2);
        int expectedHashCodeResult = achievementDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, achievementDeleteRequest2.hashCode());
    }
}

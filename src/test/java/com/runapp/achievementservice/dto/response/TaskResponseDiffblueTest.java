package com.runapp.achievementservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TaskResponse.class})
@ExtendWith(SpringExtension.class)
class TaskResponseDiffblueTest {
    @Autowired
    private TaskResponse taskResponse;

    /**
     * Method under test: {@link TaskResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(taskResponse.canEqual("Other"));
        assertTrue(taskResponse.canEqual(taskResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TaskResponse#TaskResponse()}
     *   <li>{@link TaskResponse#setId(int)}
     *   <li>{@link TaskResponse#setTaskDescription(String)}
     *   <li>{@link TaskResponse#setTaskImageUrl(String)}
     *   <li>{@link TaskResponse#setTaskRewardId(int)}
     *   <li>{@link TaskResponse#setTaskTittle(String)}
     *   <li>{@link TaskResponse#toString()}
     *   <li>{@link TaskResponse#getId()}
     *   <li>{@link TaskResponse#getTaskDescription()}
     *   <li>{@link TaskResponse#getTaskImageUrl()}
     *   <li>{@link TaskResponse#getTaskRewardId()}
     *   <li>{@link TaskResponse#getTaskTittle()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TaskResponse actualTaskResponse = new TaskResponse();
        actualTaskResponse.setId(1);
        actualTaskResponse.setTaskDescription("Task Description");
        actualTaskResponse.setTaskImageUrl("https://example.org/example");
        actualTaskResponse.setTaskRewardId(1);
        actualTaskResponse.setTaskTittle("Task Tittle");
        String actualToStringResult = actualTaskResponse.toString();
        int actualId = actualTaskResponse.getId();
        String actualTaskDescription = actualTaskResponse.getTaskDescription();
        String actualTaskImageUrl = actualTaskResponse.getTaskImageUrl();
        int actualTaskRewardId = actualTaskResponse.getTaskRewardId();
        assertEquals("Task Description", actualTaskDescription);
        assertEquals("Task Tittle", actualTaskResponse.getTaskTittle());
        assertEquals("TaskResponse(id=1, taskTittle=Task Tittle, taskDescription=Task Description, taskRewardId=1,"
                + " taskImageUrl=https://example.org/example)", actualToStringResult);
        assertEquals("https://example.org/example", actualTaskImageUrl);
        assertEquals(1, actualId);
        assertEquals(1, actualTaskRewardId);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TaskResponse#TaskResponse(int, String, String, int, String)}
     *   <li>{@link TaskResponse#setId(int)}
     *   <li>{@link TaskResponse#setTaskDescription(String)}
     *   <li>{@link TaskResponse#setTaskImageUrl(String)}
     *   <li>{@link TaskResponse#setTaskRewardId(int)}
     *   <li>{@link TaskResponse#setTaskTittle(String)}
     *   <li>{@link TaskResponse#toString()}
     *   <li>{@link TaskResponse#getId()}
     *   <li>{@link TaskResponse#getTaskDescription()}
     *   <li>{@link TaskResponse#getTaskImageUrl()}
     *   <li>{@link TaskResponse#getTaskRewardId()}
     *   <li>{@link TaskResponse#getTaskTittle()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        TaskResponse actualTaskResponse = new TaskResponse(1, "Task Tittle", "Task Description", 1,
                "https://example.org/example");
        actualTaskResponse.setId(1);
        actualTaskResponse.setTaskDescription("Task Description");
        actualTaskResponse.setTaskImageUrl("https://example.org/example");
        actualTaskResponse.setTaskRewardId(1);
        actualTaskResponse.setTaskTittle("Task Tittle");
        String actualToStringResult = actualTaskResponse.toString();
        int actualId = actualTaskResponse.getId();
        String actualTaskDescription = actualTaskResponse.getTaskDescription();
        String actualTaskImageUrl = actualTaskResponse.getTaskImageUrl();
        int actualTaskRewardId = actualTaskResponse.getTaskRewardId();
        assertEquals("Task Description", actualTaskDescription);
        assertEquals("Task Tittle", actualTaskResponse.getTaskTittle());
        assertEquals("TaskResponse(id=1, taskTittle=Task Tittle, taskDescription=Task Description, taskRewardId=1,"
                + " taskImageUrl=https://example.org/example)", actualToStringResult);
        assertEquals("https://example.org/example", actualTaskImageUrl);
        assertEquals(1, actualId);
        assertEquals(1, actualTaskRewardId);
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"), null);
        assertNotEquals(new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"),
                "Different type to TaskResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TaskResponse#equals(Object)}
     *   <li>{@link TaskResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", "Task Description", 1,
                "https://example.org/example");
        assertEquals(taskResponse, taskResponse);
        int expectedHashCodeResult = taskResponse.hashCode();
        assertEquals(expectedHashCodeResult, taskResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TaskResponse#equals(Object)}
     *   <li>{@link TaskResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", "Task Description", 1,
                "https://example.org/example");
        TaskResponse taskResponse2 = new TaskResponse(1, "Task Tittle", "Task Description", 1,
                "https://example.org/example");

        assertEquals(taskResponse, taskResponse2);
        int expectedHashCodeResult = taskResponse.hashCode();
        assertEquals(expectedHashCodeResult, taskResponse2.hashCode());
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        TaskResponse taskResponse = new TaskResponse(2, "Task Tittle", "Task Description", 1,
                "https://example.org/example");
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Description", "Task Description", 1,
                "https://example.org/example");
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        TaskResponse taskResponse = new TaskResponse(1, null, "Task Description", 1, "https://example.org/example");
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", "Task Tittle", 1, "https://example.org/example");
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", null, 1, "https://example.org/example");
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", "Task Description", 2,
                "https://example.org/example");
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", "Task Description", 1, "Task Tittle");
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Method under test: {@link TaskResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", "Task Description", 1, null);
        assertNotEquals(taskResponse,
                new TaskResponse(1, "Task Tittle", "Task Description", 1, "https://example.org/example"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TaskResponse#equals(Object)}
     *   <li>{@link TaskResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        TaskResponse taskResponse = new TaskResponse(1, null, "Task Description", 1, "https://example.org/example");
        TaskResponse taskResponse2 = new TaskResponse(1, null, "Task Description", 1, "https://example.org/example");

        assertEquals(taskResponse, taskResponse2);
        int expectedHashCodeResult = taskResponse.hashCode();
        assertEquals(expectedHashCodeResult, taskResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TaskResponse#equals(Object)}
     *   <li>{@link TaskResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        TaskResponse taskResponse = new TaskResponse(1, "Task Tittle", null, 1, "https://example.org/example");
        TaskResponse taskResponse2 = new TaskResponse(1, "Task Tittle", null, 1, "https://example.org/example");

        assertEquals(taskResponse, taskResponse2);
        int expectedHashCodeResult = taskResponse.hashCode();
        assertEquals(expectedHashCodeResult, taskResponse2.hashCode());
    }
}

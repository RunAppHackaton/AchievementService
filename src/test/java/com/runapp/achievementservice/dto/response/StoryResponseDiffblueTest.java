package com.runapp.achievementservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StoryResponse.class})
@ExtendWith(SpringExtension.class)
class StoryResponseDiffblueTest {
    @Autowired
    private StoryResponse storyResponse;

    /**
     * Method under test: {@link StoryResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(storyResponse.canEqual("Other"));
        assertTrue(storyResponse.canEqual(storyResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StoryResponse#StoryResponse()}
     *   <li>{@link StoryResponse#setCategory(String)}
     *   <li>{@link StoryResponse#setDescription(String)}
     *   <li>{@link StoryResponse#setDifficultLevel(int)}
     *   <li>{@link StoryResponse#setId(int)}
     *   <li>{@link StoryResponse#setStoryImageUrl(String)}
     *   <li>{@link StoryResponse#setTaskModelList(List)}
     *   <li>{@link StoryResponse#setTittle(String)}
     *   <li>{@link StoryResponse#toString()}
     *   <li>{@link StoryResponse#getCategory()}
     *   <li>{@link StoryResponse#getDescription()}
     *   <li>{@link StoryResponse#getDifficultLevel()}
     *   <li>{@link StoryResponse#getId()}
     *   <li>{@link StoryResponse#getStoryImageUrl()}
     *   <li>{@link StoryResponse#getTaskModelList()}
     *   <li>{@link StoryResponse#getTittle()}
     * </ul>
     */
    @Test
    void testConstructor() {
        StoryResponse actualStoryResponse = new StoryResponse();
        actualStoryResponse.setCategory("Category");
        actualStoryResponse.setDescription("The characteristics of someone or something");
        actualStoryResponse.setDifficultLevel(1);
        actualStoryResponse.setId(1);
        actualStoryResponse.setStoryImageUrl("https://example.org/example");
        ArrayList<TaskResponse> taskModelList = new ArrayList<>();
        actualStoryResponse.setTaskModelList(taskModelList);
        actualStoryResponse.setTittle("Tittle");
        String actualToStringResult = actualStoryResponse.toString();
        String actualCategory = actualStoryResponse.getCategory();
        String actualDescription = actualStoryResponse.getDescription();
        int actualDifficultLevel = actualStoryResponse.getDifficultLevel();
        int actualId = actualStoryResponse.getId();
        String actualStoryImageUrl = actualStoryResponse.getStoryImageUrl();
        List<TaskResponse> actualTaskModelList = actualStoryResponse.getTaskModelList();
        assertEquals("Category", actualCategory);
        assertEquals(
                "StoryResponse(id=1, tittle=Tittle, description=The characteristics of someone or something,"
                        + " category=Category, difficultLevel=1, storyImageUrl=https://example.org/example, taskModelList=[])",
                actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("Tittle", actualStoryResponse.getTittle());
        assertEquals("https://example.org/example", actualStoryImageUrl);
        assertEquals(1, actualDifficultLevel);
        assertEquals(1, actualId);
        assertSame(taskModelList, actualTaskModelList);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link StoryResponse#StoryResponse(int, String, String, String, int, String, List)}
     *   <li>{@link StoryResponse#setCategory(String)}
     *   <li>{@link StoryResponse#setDescription(String)}
     *   <li>{@link StoryResponse#setDifficultLevel(int)}
     *   <li>{@link StoryResponse#setId(int)}
     *   <li>{@link StoryResponse#setStoryImageUrl(String)}
     *   <li>{@link StoryResponse#setTaskModelList(List)}
     *   <li>{@link StoryResponse#setTittle(String)}
     *   <li>{@link StoryResponse#toString()}
     *   <li>{@link StoryResponse#getCategory()}
     *   <li>{@link StoryResponse#getDescription()}
     *   <li>{@link StoryResponse#getDifficultLevel()}
     *   <li>{@link StoryResponse#getId()}
     *   <li>{@link StoryResponse#getStoryImageUrl()}
     *   <li>{@link StoryResponse#getTaskModelList()}
     *   <li>{@link StoryResponse#getTittle()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<TaskResponse> taskModelList = new ArrayList<>();
        StoryResponse actualStoryResponse = new StoryResponse(1, "Tittle", "The characteristics of someone or something",
                "Category", 1, "https://example.org/example", taskModelList);
        actualStoryResponse.setCategory("Category");
        actualStoryResponse.setDescription("The characteristics of someone or something");
        actualStoryResponse.setDifficultLevel(1);
        actualStoryResponse.setId(1);
        actualStoryResponse.setStoryImageUrl("https://example.org/example");
        ArrayList<TaskResponse> taskModelList2 = new ArrayList<>();
        actualStoryResponse.setTaskModelList(taskModelList2);
        actualStoryResponse.setTittle("Tittle");
        String actualToStringResult = actualStoryResponse.toString();
        String actualCategory = actualStoryResponse.getCategory();
        String actualDescription = actualStoryResponse.getDescription();
        int actualDifficultLevel = actualStoryResponse.getDifficultLevel();
        int actualId = actualStoryResponse.getId();
        String actualStoryImageUrl = actualStoryResponse.getStoryImageUrl();
        List<TaskResponse> actualTaskModelList = actualStoryResponse.getTaskModelList();
        assertEquals("Category", actualCategory);
        assertEquals(
                "StoryResponse(id=1, tittle=Tittle, description=The characteristics of someone or something,"
                        + " category=Category, difficultLevel=1, storyImageUrl=https://example.org/example, taskModelList=[])",
                actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("Tittle", actualStoryResponse.getTittle());
        assertEquals("https://example.org/example", actualStoryImageUrl);
        assertEquals(1, actualDifficultLevel);
        assertEquals(1, actualId);
        assertEquals(taskModelList, actualTaskModelList);
        assertSame(taskModelList2, actualTaskModelList);
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new StoryResponse(), null);
        assertNotEquals(new StoryResponse(), "Different type to StoryResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StoryResponse#equals(Object)}
     *   <li>{@link StoryResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        StoryResponse storyResponse = new StoryResponse();
        assertEquals(storyResponse, storyResponse);
        int expectedHashCodeResult = storyResponse.hashCode();
        assertEquals(expectedHashCodeResult, storyResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StoryResponse#equals(Object)}
     *   <li>{@link StoryResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        StoryResponse storyResponse = new StoryResponse();
        StoryResponse storyResponse2 = new StoryResponse();
        assertEquals(storyResponse, storyResponse2);
        int expectedHashCodeResult = storyResponse.hashCode();
        assertEquals(expectedHashCodeResult, storyResponse2.hashCode());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        StoryResponse storyResponse = new StoryResponse(1, "Tittle", "The characteristics of someone or something",
                "Category", 1, "https://example.org/example", new ArrayList<>());
        assertNotEquals(storyResponse, new StoryResponse());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        StoryResponse storyResponse = new StoryResponse();
        storyResponse.setTittle("Tittle");
        assertNotEquals(storyResponse, new StoryResponse());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        StoryResponse storyResponse = new StoryResponse();
        storyResponse.setDescription("The characteristics of someone or something");
        assertNotEquals(storyResponse, new StoryResponse());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        StoryResponse storyResponse = new StoryResponse();
        storyResponse.setCategory("Category");
        assertNotEquals(storyResponse, new StoryResponse());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        StoryResponse storyResponse = new StoryResponse();
        storyResponse.setDifficultLevel(1);
        assertNotEquals(storyResponse, new StoryResponse());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        StoryResponse storyResponse = new StoryResponse();
        storyResponse.setStoryImageUrl("https://example.org/example");
        assertNotEquals(storyResponse, new StoryResponse());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        StoryResponse storyResponse = new StoryResponse();
        storyResponse.setTaskModelList(new ArrayList<>());
        assertNotEquals(storyResponse, new StoryResponse());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StoryResponse#equals(Object)}
     *   <li>{@link StoryResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        StoryResponse storyResponse = new StoryResponse(1, "Tittle", "The characteristics of someone or something",
                "Category", 1, "https://example.org/example", new ArrayList<>());
        StoryResponse storyResponse2 = new StoryResponse(1, "Tittle", "The characteristics of someone or something",
                "Category", 1, "https://example.org/example", new ArrayList<>());

        assertEquals(storyResponse, storyResponse2);
        int expectedHashCodeResult = storyResponse.hashCode();
        assertEquals(expectedHashCodeResult, storyResponse2.hashCode());
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        StoryResponse storyResponse = new StoryResponse();

        StoryResponse storyResponse2 = new StoryResponse();
        storyResponse2.setTittle("Tittle");
        assertNotEquals(storyResponse, storyResponse2);
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals13() {
        StoryResponse storyResponse = new StoryResponse();

        StoryResponse storyResponse2 = new StoryResponse();
        storyResponse2.setDescription("The characteristics of someone or something");
        assertNotEquals(storyResponse, storyResponse2);
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals14() {
        StoryResponse storyResponse = new StoryResponse();

        StoryResponse storyResponse2 = new StoryResponse();
        storyResponse2.setCategory("Category");
        assertNotEquals(storyResponse, storyResponse2);
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals15() {
        StoryResponse storyResponse = new StoryResponse();

        StoryResponse storyResponse2 = new StoryResponse();
        storyResponse2.setStoryImageUrl("https://example.org/example");
        assertNotEquals(storyResponse, storyResponse2);
    }

    /**
     * Method under test: {@link StoryResponse#equals(Object)}
     */
    @Test
    void testEquals16() {
        StoryResponse storyResponse = new StoryResponse();

        StoryResponse storyResponse2 = new StoryResponse();
        storyResponse2.setTaskModelList(new ArrayList<>());
        assertNotEquals(storyResponse, storyResponse2);
    }
}

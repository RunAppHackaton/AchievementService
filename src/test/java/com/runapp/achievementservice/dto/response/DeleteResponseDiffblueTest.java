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

@ContextConfiguration(classes = {DeleteResponse.class})
@ExtendWith(SpringExtension.class)
class DeleteResponseDiffblueTest {
    @Autowired
    private DeleteResponse deleteResponse;

    /**
     * Method under test: {@link DeleteResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(deleteResponse.canEqual("Other"));
        assertTrue(deleteResponse.canEqual(deleteResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteResponse#DeleteResponse()}
     *   <li>{@link DeleteResponse#setResponse(String)}
     *   <li>{@link DeleteResponse#toString()}
     *   <li>{@link DeleteResponse#getResponse()}
     * </ul>
     */
    @Test
    void testConstructor() {
        DeleteResponse actualDeleteResponse = new DeleteResponse();
        actualDeleteResponse.setResponse("Response");
        String actualToStringResult = actualDeleteResponse.toString();
        assertEquals("DeleteResponse(response=Response)", actualToStringResult);
        assertEquals("Response", actualDeleteResponse.getResponse());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteResponse#DeleteResponse(String)}
     *   <li>{@link DeleteResponse#setResponse(String)}
     *   <li>{@link DeleteResponse#toString()}
     *   <li>{@link DeleteResponse#getResponse()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        DeleteResponse actualDeleteResponse = new DeleteResponse("Response");
        actualDeleteResponse.setResponse("Response");
        String actualToStringResult = actualDeleteResponse.toString();
        assertEquals("DeleteResponse(response=Response)", actualToStringResult);
        assertEquals("Response", actualDeleteResponse.getResponse());
    }

    /**
     * Method under test: {@link DeleteResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new DeleteResponse("Response"), null);
        assertNotEquals(new DeleteResponse("Response"), "Different type to DeleteResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteResponse#equals(Object)}
     *   <li>{@link DeleteResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        DeleteResponse deleteResponse = new DeleteResponse("Response");
        assertEquals(deleteResponse, deleteResponse);
        int expectedHashCodeResult = deleteResponse.hashCode();
        assertEquals(expectedHashCodeResult, deleteResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteResponse#equals(Object)}
     *   <li>{@link DeleteResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        DeleteResponse deleteResponse = new DeleteResponse("Response");
        DeleteResponse deleteResponse2 = new DeleteResponse("Response");
        assertEquals(deleteResponse, deleteResponse2);
        int expectedHashCodeResult = deleteResponse.hashCode();
        assertEquals(expectedHashCodeResult, deleteResponse2.hashCode());
    }

    /**
     * Method under test: {@link DeleteResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        DeleteResponse deleteResponse = new DeleteResponse(null);
        assertNotEquals(deleteResponse, new DeleteResponse("Response"));
    }

    /**
     * Method under test: {@link DeleteResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        DeleteResponse deleteResponse = new DeleteResponse("com.runapp.achievementservice.dto.response.DeleteResponse");
        assertNotEquals(deleteResponse, new DeleteResponse("Response"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteResponse#equals(Object)}
     *   <li>{@link DeleteResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals6() {
        DeleteResponse deleteResponse = new DeleteResponse(null);
        DeleteResponse deleteResponse2 = new DeleteResponse(null);
        assertEquals(deleteResponse, deleteResponse2);
        int expectedHashCodeResult = deleteResponse.hashCode();
        assertEquals(expectedHashCodeResult, deleteResponse2.hashCode());
    }
}

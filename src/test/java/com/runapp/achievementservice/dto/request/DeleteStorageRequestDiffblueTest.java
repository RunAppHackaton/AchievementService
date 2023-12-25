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

@ContextConfiguration(classes = {DeleteStorageRequest.class})
@ExtendWith(SpringExtension.class)
class DeleteStorageRequestDiffblueTest {
    @Autowired
    private DeleteStorageRequest deleteStorageRequest;

    /**
     * Method under test: {@link DeleteStorageRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(deleteStorageRequest.canEqual("Other"));
        assertTrue(deleteStorageRequest.canEqual(deleteStorageRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteStorageRequest#DeleteStorageRequest()}
     *   <li>{@link DeleteStorageRequest#setDirectory(String)}
     *   <li>{@link DeleteStorageRequest#setFile_uri(String)}
     *   <li>{@link DeleteStorageRequest#toString()}
     *   <li>{@link DeleteStorageRequest#getDirectory()}
     *   <li>{@link DeleteStorageRequest#getFile_uri()}
     * </ul>
     */
    @Test
    void testConstructor() {
        DeleteStorageRequest actualDeleteStorageRequest = new DeleteStorageRequest();
        actualDeleteStorageRequest.setDirectory("/directory");
        actualDeleteStorageRequest.setFile_uri("File uri");
        String actualToStringResult = actualDeleteStorageRequest.toString();
        String actualDirectory = actualDeleteStorageRequest.getDirectory();
        assertEquals("/directory", actualDirectory);
        assertEquals("DeleteStorageRequest(file_uri=File uri, directory=/directory)", actualToStringResult);
        assertEquals("File uri", actualDeleteStorageRequest.getFile_uri());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteStorageRequest#DeleteStorageRequest(String, String)}
     *   <li>{@link DeleteStorageRequest#setDirectory(String)}
     *   <li>{@link DeleteStorageRequest#setFile_uri(String)}
     *   <li>{@link DeleteStorageRequest#toString()}
     *   <li>{@link DeleteStorageRequest#getDirectory()}
     *   <li>{@link DeleteStorageRequest#getFile_uri()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        DeleteStorageRequest actualDeleteStorageRequest = new DeleteStorageRequest("File uri", "/directory");
        actualDeleteStorageRequest.setDirectory("/directory");
        actualDeleteStorageRequest.setFile_uri("File uri");
        String actualToStringResult = actualDeleteStorageRequest.toString();
        String actualDirectory = actualDeleteStorageRequest.getDirectory();
        assertEquals("/directory", actualDirectory);
        assertEquals("DeleteStorageRequest(file_uri=File uri, directory=/directory)", actualToStringResult);
        assertEquals("File uri", actualDeleteStorageRequest.getFile_uri());
    }

    /**
     * Method under test: {@link DeleteStorageRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new DeleteStorageRequest("File uri", "/directory"), null);
        assertNotEquals(new DeleteStorageRequest("File uri", "/directory"), "Different type to DeleteStorageRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteStorageRequest#equals(Object)}
     *   <li>{@link DeleteStorageRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest("File uri", "/directory");
        assertEquals(deleteStorageRequest, deleteStorageRequest);
        int expectedHashCodeResult = deleteStorageRequest.hashCode();
        assertEquals(expectedHashCodeResult, deleteStorageRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteStorageRequest#equals(Object)}
     *   <li>{@link DeleteStorageRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest("File uri", "/directory");
        DeleteStorageRequest deleteStorageRequest2 = new DeleteStorageRequest("File uri", "/directory");

        assertEquals(deleteStorageRequest, deleteStorageRequest2);
        int expectedHashCodeResult = deleteStorageRequest.hashCode();
        assertEquals(expectedHashCodeResult, deleteStorageRequest2.hashCode());
    }

    /**
     * Method under test: {@link DeleteStorageRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest("/directory", "/directory");
        assertNotEquals(deleteStorageRequest, new DeleteStorageRequest("File uri", "/directory"));
    }

    /**
     * Method under test: {@link DeleteStorageRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest(null, "/directory");
        assertNotEquals(deleteStorageRequest, new DeleteStorageRequest("File uri", "/directory"));
    }

    /**
     * Method under test: {@link DeleteStorageRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest("File uri", "File uri");
        assertNotEquals(deleteStorageRequest, new DeleteStorageRequest("File uri", "/directory"));
    }

    /**
     * Method under test: {@link DeleteStorageRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest("File uri", null);
        assertNotEquals(deleteStorageRequest, new DeleteStorageRequest("File uri", "/directory"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteStorageRequest#equals(Object)}
     *   <li>{@link DeleteStorageRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest(null, "/directory");
        DeleteStorageRequest deleteStorageRequest2 = new DeleteStorageRequest(null, "/directory");

        assertEquals(deleteStorageRequest, deleteStorageRequest2);
        int expectedHashCodeResult = deleteStorageRequest.hashCode();
        assertEquals(expectedHashCodeResult, deleteStorageRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DeleteStorageRequest#equals(Object)}
     *   <li>{@link DeleteStorageRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        DeleteStorageRequest deleteStorageRequest = new DeleteStorageRequest("File uri", null);
        DeleteStorageRequest deleteStorageRequest2 = new DeleteStorageRequest("File uri", null);

        assertEquals(deleteStorageRequest, deleteStorageRequest2);
        int expectedHashCodeResult = deleteStorageRequest.hashCode();
        assertEquals(expectedHashCodeResult, deleteStorageRequest2.hashCode());
    }
}

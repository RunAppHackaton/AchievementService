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

@ContextConfiguration(classes = {StorageServiceResponse.class})
@ExtendWith(SpringExtension.class)
class StorageServiceResponseDiffblueTest {
    @Autowired
    private StorageServiceResponse storageServiceResponse;

    /**
     * Method under test: {@link StorageServiceResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(storageServiceResponse.canEqual("Other"));
        assertTrue(storageServiceResponse.canEqual(storageServiceResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StorageServiceResponse#StorageServiceResponse()}
     *   <li>{@link StorageServiceResponse#setFile_uri(String)}
     *   <li>{@link StorageServiceResponse#toString()}
     *   <li>{@link StorageServiceResponse#getFile_uri()}
     * </ul>
     */
    @Test
    void testConstructor() {
        StorageServiceResponse actualStorageServiceResponse = new StorageServiceResponse();
        actualStorageServiceResponse.setFile_uri("File uri");
        String actualToStringResult = actualStorageServiceResponse.toString();
        assertEquals("File uri", actualStorageServiceResponse.getFile_uri());
        assertEquals("StorageServiceResponse(file_uri=File uri)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StorageServiceResponse#StorageServiceResponse(String)}
     *   <li>{@link StorageServiceResponse#setFile_uri(String)}
     *   <li>{@link StorageServiceResponse#toString()}
     *   <li>{@link StorageServiceResponse#getFile_uri()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        StorageServiceResponse actualStorageServiceResponse = new StorageServiceResponse("File uri");
        actualStorageServiceResponse.setFile_uri("File uri");
        String actualToStringResult = actualStorageServiceResponse.toString();
        assertEquals("File uri", actualStorageServiceResponse.getFile_uri());
        assertEquals("StorageServiceResponse(file_uri=File uri)", actualToStringResult);
    }

    /**
     * Method under test: {@link StorageServiceResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new StorageServiceResponse("File uri"), null);
        assertNotEquals(new StorageServiceResponse("File uri"), "Different type to StorageServiceResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StorageServiceResponse#equals(Object)}
     *   <li>{@link StorageServiceResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        StorageServiceResponse storageServiceResponse = new StorageServiceResponse("File uri");
        assertEquals(storageServiceResponse, storageServiceResponse);
        int expectedHashCodeResult = storageServiceResponse.hashCode();
        assertEquals(expectedHashCodeResult, storageServiceResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StorageServiceResponse#equals(Object)}
     *   <li>{@link StorageServiceResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        StorageServiceResponse storageServiceResponse = new StorageServiceResponse("File uri");
        StorageServiceResponse storageServiceResponse2 = new StorageServiceResponse("File uri");
        assertEquals(storageServiceResponse, storageServiceResponse2);
        int expectedHashCodeResult = storageServiceResponse.hashCode();
        assertEquals(expectedHashCodeResult, storageServiceResponse2.hashCode());
    }

    /**
     * Method under test: {@link StorageServiceResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        StorageServiceResponse storageServiceResponse = new StorageServiceResponse(null);
        assertNotEquals(storageServiceResponse, new StorageServiceResponse("File uri"));
    }

    /**
     * Method under test: {@link StorageServiceResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        StorageServiceResponse storageServiceResponse = new StorageServiceResponse(
                "com.runapp.achievementservice.dto.response.StorageServiceResponse");
        assertNotEquals(storageServiceResponse, new StorageServiceResponse("File uri"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StorageServiceResponse#equals(Object)}
     *   <li>{@link StorageServiceResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals6() {
        StorageServiceResponse storageServiceResponse = new StorageServiceResponse(null);
        StorageServiceResponse storageServiceResponse2 = new StorageServiceResponse(null);
        assertEquals(storageServiceResponse, storageServiceResponse2);
        int expectedHashCodeResult = storageServiceResponse.hashCode();
        assertEquals(expectedHashCodeResult, storageServiceResponse2.hashCode());
    }
}

package com.runapp.achievementservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserResponse.class})
@ExtendWith(SpringExtension.class)
class UserResponseDiffblueTest {
    @Autowired
    private UserResponse userResponse;

    /**
     * Method under test: {@link UserResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(userResponse.canEqual("Other"));
        assertTrue(userResponse.canEqual(userResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#UserResponse()}
     *   <li>{@link UserResponse#setCreateDate(LocalDateTime)}
     *   <li>{@link UserResponse#setEmail(String)}
     *   <li>{@link UserResponse#setFirstName(String)}
     *   <li>{@link UserResponse#setId(Long)}
     *   <li>{@link UserResponse#setLastName(String)}
     *   <li>{@link UserResponse#setRole(String)}
     *   <li>{@link UserResponse#setUserImageUrl(String)}
     *   <li>{@link UserResponse#setUsername(String)}
     *   <li>{@link UserResponse#toString()}
     *   <li>{@link UserResponse#getCreateDate()}
     *   <li>{@link UserResponse#getEmail()}
     *   <li>{@link UserResponse#getFirstName()}
     *   <li>{@link UserResponse#getId()}
     *   <li>{@link UserResponse#getLastName()}
     *   <li>{@link UserResponse#getRole()}
     *   <li>{@link UserResponse#getUserImageUrl()}
     *   <li>{@link UserResponse#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserResponse actualUserResponse = new UserResponse();
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualUserResponse.setCreateDate(createDate);
        actualUserResponse.setEmail("jane.doe@example.org");
        actualUserResponse.setFirstName("Jane");
        actualUserResponse.setId(1L);
        actualUserResponse.setLastName("Doe");
        actualUserResponse.setRole("Role");
        actualUserResponse.setUserImageUrl("https://example.org/example");
        actualUserResponse.setUsername("janedoe");
        String actualToStringResult = actualUserResponse.toString();
        LocalDateTime actualCreateDate = actualUserResponse.getCreateDate();
        String actualEmail = actualUserResponse.getEmail();
        String actualFirstName = actualUserResponse.getFirstName();
        Long actualId = actualUserResponse.getId();
        String actualLastName = actualUserResponse.getLastName();
        String actualRole = actualUserResponse.getRole();
        String actualUserImageUrl = actualUserResponse.getUserImageUrl();
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("Role", actualRole);
        assertEquals(
                "UserResponse(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=Role, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example)",
                actualToStringResult);
        assertEquals("https://example.org/example", actualUserImageUrl);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("janedoe", actualUserResponse.getUsername());
        assertEquals(1L, actualId.longValue());
        assertSame(createDate, actualCreateDate);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link UserResponse#UserResponse(Long, String, String, String, String, String, LocalDateTime, String)}
     *   <li>{@link UserResponse#setCreateDate(LocalDateTime)}
     *   <li>{@link UserResponse#setEmail(String)}
     *   <li>{@link UserResponse#setFirstName(String)}
     *   <li>{@link UserResponse#setId(Long)}
     *   <li>{@link UserResponse#setLastName(String)}
     *   <li>{@link UserResponse#setRole(String)}
     *   <li>{@link UserResponse#setUserImageUrl(String)}
     *   <li>{@link UserResponse#setUsername(String)}
     *   <li>{@link UserResponse#toString()}
     *   <li>{@link UserResponse#getCreateDate()}
     *   <li>{@link UserResponse#getEmail()}
     *   <li>{@link UserResponse#getFirstName()}
     *   <li>{@link UserResponse#getId()}
     *   <li>{@link UserResponse#getLastName()}
     *   <li>{@link UserResponse#getRole()}
     *   <li>{@link UserResponse#getUserImageUrl()}
     *   <li>{@link UserResponse#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        UserResponse actualUserResponse = new UserResponse(1L, "janedoe", "Jane", "Doe", "Role", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualUserResponse.setCreateDate(createDate);
        actualUserResponse.setEmail("jane.doe@example.org");
        actualUserResponse.setFirstName("Jane");
        actualUserResponse.setId(1L);
        actualUserResponse.setLastName("Doe");
        actualUserResponse.setRole("Role");
        actualUserResponse.setUserImageUrl("https://example.org/example");
        actualUserResponse.setUsername("janedoe");
        String actualToStringResult = actualUserResponse.toString();
        LocalDateTime actualCreateDate = actualUserResponse.getCreateDate();
        String actualEmail = actualUserResponse.getEmail();
        String actualFirstName = actualUserResponse.getFirstName();
        Long actualId = actualUserResponse.getId();
        String actualLastName = actualUserResponse.getLastName();
        String actualRole = actualUserResponse.getRole();
        String actualUserImageUrl = actualUserResponse.getUserImageUrl();
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("Role", actualRole);
        assertEquals(
                "UserResponse(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=Role, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example)",
                actualToStringResult);
        assertEquals("https://example.org/example", actualUserImageUrl);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("janedoe", actualUserResponse.getUsername());
        assertEquals(1L, actualId.longValue());
        assertSame(createDate, actualCreateDate);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UserResponse(), null);
        assertNotEquals(new UserResponse(), "Different type to UserResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UserResponse userResponse = new UserResponse();
        assertEquals(userResponse, userResponse);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserResponse userResponse = new UserResponse();
        UserResponse userResponse2 = new UserResponse();
        assertEquals(userResponse, userResponse2);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse2.hashCode());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        UserResponse userResponse = new UserResponse(1L, "janedoe", "Jane", "Doe", "Role", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserResponse userResponse = new UserResponse();
        assertNotEquals(userResponse, new UserResponse(1L, "janedoe", "Jane", "Doe", "Role", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername("janedoe");
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName("Jane");
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        UserResponse userResponse = new UserResponse();
        userResponse.setLastName("Doe");
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        UserResponse userResponse = new UserResponse();
        userResponse.setRole("Role");
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("jane.doe@example.org");
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        UserResponse userResponse = new UserResponse();
        userResponse.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserImageUrl("https://example.org/example");
        assertNotEquals(userResponse, new UserResponse());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        UserResponse userResponse = new UserResponse(1L, "janedoe", "Jane", "Doe", "Role", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");
        UserResponse userResponse2 = new UserResponse(1L, "janedoe", "Jane", "Doe", "Role", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");

        assertEquals(userResponse, userResponse2);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse2.hashCode());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals14() {
        UserResponse userResponse = new UserResponse();

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setUsername("janedoe");
        assertNotEquals(userResponse, userResponse2);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals15() {
        UserResponse userResponse = new UserResponse();

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setFirstName("Jane");
        assertNotEquals(userResponse, userResponse2);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals16() {
        UserResponse userResponse = new UserResponse();

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setLastName("Doe");
        assertNotEquals(userResponse, userResponse2);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals17() {
        UserResponse userResponse = new UserResponse();

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setRole("Role");
        assertNotEquals(userResponse, userResponse2);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals18() {
        UserResponse userResponse = new UserResponse();

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setEmail("jane.doe@example.org");
        assertNotEquals(userResponse, userResponse2);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals19() {
        UserResponse userResponse = new UserResponse();

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(userResponse, userResponse2);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals20() {
        UserResponse userResponse = new UserResponse();

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setUserImageUrl("https://example.org/example");
        assertNotEquals(userResponse, userResponse2);
    }
}

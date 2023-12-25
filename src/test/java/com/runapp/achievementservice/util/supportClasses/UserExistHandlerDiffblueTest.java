package com.runapp.achievementservice.util.supportClasses;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.feignClient.ProfileServiceClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserExistHandler.class})
@ExtendWith(SpringExtension.class)
class UserExistHandlerDiffblueTest {
    @MockBean
    private ProfileServiceClient profileServiceClient;

    @Autowired
    private UserExistHandler userExistHandler;

    /**
     * Method under test: {@link UserExistHandler#checkUserExist(Long)}
     */
    @Test
    void testCheckUserExist() {
        when(profileServiceClient.getUserById(Mockito.<Long>any())).thenReturn(null);
        userExistHandler.checkUserExist(1L);
        verify(profileServiceClient).getUserById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserExistHandler#checkUserExist(Long)}
     */
    @Test
    void testCheckUserExist2() {
        when(profileServiceClient.getUserById(Mockito.<Long>any()))
                .thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> userExistHandler.checkUserExist(1L));
        verify(profileServiceClient).getUserById(Mockito.<Long>any());
    }
}

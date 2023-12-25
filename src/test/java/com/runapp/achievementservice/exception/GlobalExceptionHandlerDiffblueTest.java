package com.runapp.achievementservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Executable;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {GlobalExceptionHandler.class})
@ExtendWith(SpringExtension.class)
class GlobalExceptionHandlerDiffblueTest {
    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    /**
     * Method under test:
     * {@link GlobalExceptionHandler#handleMaxUploadSizeExceededException(NoEntityFoundException, WebRequest)}
     */
    @Test
    void testHandleMaxUploadSizeExceededException() {
        NoEntityFoundException ex = new NoEntityFoundException("An error occurred");
        ResponseEntity<Object> actualHandleMaxUploadSizeExceededExceptionResult = globalExceptionHandler
                .handleMaxUploadSizeExceededException(ex, new ServletWebRequest(new MockHttpServletRequest()));
        assertEquals(3, ((Map<String, String>) actualHandleMaxUploadSizeExceededExceptionResult.getBody()).size());
        assertEquals(404, actualHandleMaxUploadSizeExceededExceptionResult.getStatusCodeValue());
        assertTrue(actualHandleMaxUploadSizeExceededExceptionResult.hasBody());
        assertTrue(actualHandleMaxUploadSizeExceededExceptionResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link GlobalExceptionHandler#handleMaxUploadSizeExceededException(NoEntityFoundException, WebRequest)}
     */
    @Test
    void testHandleMaxUploadSizeExceededException2() {
        NoEntityFoundException ex = mock(NoEntityFoundException.class);
        when(ex.getMessage()).thenReturn("Not all who wander are lost");
        ResponseEntity<Object> actualHandleMaxUploadSizeExceededExceptionResult = globalExceptionHandler
                .handleMaxUploadSizeExceededException(ex, new ServletWebRequest(new MockHttpServletRequest()));
        verify(ex).getMessage();
        assertEquals(3, ((Map<String, String>) actualHandleMaxUploadSizeExceededExceptionResult.getBody()).size());
        assertEquals(404, actualHandleMaxUploadSizeExceededExceptionResult.getStatusCodeValue());
        assertTrue(actualHandleMaxUploadSizeExceededExceptionResult.hasBody());
        assertTrue(actualHandleMaxUploadSizeExceededExceptionResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link GlobalExceptionHandler#handleMethodArgumentNotValid(MethodArgumentNotValidException, HttpHeaders, HttpStatusCode, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleMethodArgumentNotValid() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.HttpStatusCode.value()" because "status" is null
        //       at com.runapp.achievementservice.exception.GlobalExceptionHandler.handleMethodArgumentNotValid(GlobalExceptionHandler.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException((Executable) null,
                new BindException("Target", "Object Name"));

        HttpHeaders headers = new HttpHeaders();
        globalExceptionHandler.handleMethodArgumentNotValid(ex, headers, null,
                new ServletWebRequest(new MockHttpServletRequest()));
    }
}

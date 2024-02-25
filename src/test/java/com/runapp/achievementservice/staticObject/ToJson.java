package com.runapp.achievementservice.staticObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ToJson {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

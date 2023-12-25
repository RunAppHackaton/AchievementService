package com.runapp.achievementservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RarityRequest.class})
@ExtendWith(SpringExtension.class)
class RarityRequestDiffblueTest {
    @Autowired
    private RarityRequest rarityRequest;

    /**
     * Method under test: {@link RarityRequest#toRarityModel()}
     */
    @Test
    void testToRarityModel() {
        assertNull(rarityRequest.toRarityModel().getName());
    }
}

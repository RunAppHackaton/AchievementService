package com.runapp.achievementservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AchievementRequest.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AchievementRequestDiffblueTest {
    @Autowired
    private AchievementRequest achievementRequest;

    /**
     * Method under test: {@link AchievementRequest#ToAchievementModel(RarityModel)}
     */
    @Test
    void testToAchievementModel() {
        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        AchievementModel actualToAchievementModelResult = achievementRequest.ToAchievementModel(rarityModel);
        assertEquals("DEFAULT", actualToAchievementModelResult.getAchievementImageUrl());
        assertNull(actualToAchievementModelResult.getDescription());
        assertNull(actualToAchievementModelResult.getName());
        assertEquals(0, actualToAchievementModelResult.getStory_id());
        assertSame(rarityModel, actualToAchievementModelResult.getRarityModel());
    }

    /**
     * Method under test: {@link AchievementRequest#ToAchievementModel(RarityModel)}
     */
    @Test
    void testToAchievementModel2() {
        RarityModel rarityModel = mock(RarityModel.class);
        doNothing().when(rarityModel).setAchievementModelList(Mockito.<List<AchievementModel>>any());
        doNothing().when(rarityModel).setId(Mockito.<Long>any());
        doNothing().when(rarityModel).setName(Mockito.<String>any());
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");
        AchievementModel actualToAchievementModelResult = achievementRequest.ToAchievementModel(rarityModel);
        verify(rarityModel).setAchievementModelList(Mockito.<List<AchievementModel>>any());
        verify(rarityModel).setId(Mockito.<Long>any());
        verify(rarityModel).setName(Mockito.<String>any());
        assertEquals("DEFAULT", actualToAchievementModelResult.getAchievementImageUrl());
        assertNull(actualToAchievementModelResult.getDescription());
        assertNull(actualToAchievementModelResult.getName());
        assertEquals(0, actualToAchievementModelResult.getStory_id());
        assertSame(rarityModel, actualToAchievementModelResult.getRarityModel());
    }
}

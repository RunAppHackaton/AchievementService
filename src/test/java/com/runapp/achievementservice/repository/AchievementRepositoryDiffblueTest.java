package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.service.serviceImpl.AchievementServiceImpl;
import com.runapp.achievementservice.staticObject.StaticAchievement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {AchievementRepository.class})
@EnableAutoConfiguration
@ExtendWith(MockitoExtension.class)
public class AchievementRepositoryDiffblueTest {

    @Mock
    private AchievementRepository achievementRepositoryMock;

    @InjectMocks
    private AchievementServiceImpl achievementService;

    @Test
    public void testFindByStoryId() {
        // Given
        int storyId = 1;
        List<AchievementModel> mockAchievements = new ArrayList<>();
        mockAchievements.add(StaticAchievement.achievementModel1());

        // Mocking the behavior of the repository method
        when(achievementRepositoryMock.findByStory_id(storyId)).thenReturn(mockAchievements);

        // When
        List<AchievementModel> achievements = achievementService.getAchievementsByStoryId(storyId);

        // Then
        assertThat(achievements).isNotNull();
        assertThat(achievements.size()).isEqualTo(1); // Assuming there are 2 achievements for storyId = 1
        assertThat(achievements.contains(StaticAchievement.achievementModel1())).isEqualTo(true);
        assertThat(achievements.size()).isEqualTo(1);
    }
}
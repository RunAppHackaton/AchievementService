package com.runapp.achievementservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.achievementservice.model.TrainingModel;

import java.time.LocalDate;

import com.runapp.achievementservice.staticObject.StaticTraining;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TrainingRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.runapp.achievementservice.model"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class TrainingRepositoryDiffblueTest {
    @MockBean
    private SqlDataSourceScriptDatabaseInitializer sqlDataSourceScriptDatabaseInitializer;

    @Autowired
    private TrainingRepository trainingRepository;

    /**
     * Method under test:
     * {@link TrainingRepository#findTrainingWithMinAveragePace()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindTrainingWithMinAveragePace() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();

        TrainingModel trainingModel2 = StaticTraining.trainingModel2();
        trainingRepository.save(trainingModel);
        trainingRepository.save(trainingModel2);
        trainingRepository.findTrainingWithMinAveragePace();
    }

    /**
     * Method under test: {@link TrainingRepository#existsByUserId(Long)}
     */

    @Test
    void testExistsByUserId() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();

        TrainingModel trainingModel2 = StaticTraining.trainingModel2();
        trainingRepository.save(trainingModel);
        trainingRepository.save(trainingModel2);
        assertTrue(trainingRepository.existsByUserId(1L));
    }

    /**
     * Method under test: {@link TrainingRepository#findAllByUserId(Long)}
     */
    @Test
    void testFindAllByUserId() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();

        TrainingModel trainingModel2 = StaticTraining.trainingModel2();
        trainingRepository.save(trainingModel);
        trainingRepository.save(trainingModel2);
        assertEquals(1, trainingRepository.findAllByUserId(1L).size());
    }
}

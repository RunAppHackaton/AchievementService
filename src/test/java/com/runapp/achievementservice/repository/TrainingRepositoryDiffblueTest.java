package com.runapp.achievementservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.achievementservice.model.TrainingModel;

import java.time.LocalDate;

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.IncorrectResultSizeDataAccessException: query did not return a unique result: 2
        //       at jdk.proxy6/jdk.proxy6.$Proxy197.findTrainingWithMinAveragePace(Unknown Source)
        //   jakarta.persistence.NonUniqueResultException: query did not return a unique result: 2
        //       at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:128)
        //       at org.hibernate.query.spi.AbstractSelectionQuery.getSingleResult(AbstractSelectionQuery.java:482)
        //       at jdk.proxy6/jdk.proxy6.$Proxy197.findTrainingWithMinAveragePace(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setUserId(1L);

        TrainingModel trainingModel2 = new TrainingModel();
        trainingModel2.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel2.setDistanceKm(-1);
        trainingModel2.setUserId(2L);
        trainingRepository.save(trainingModel);
        trainingRepository.save(trainingModel2);
        trainingRepository.findTrainingWithMinAveragePace();
    }

    /**
     * Method under test: {@link TrainingRepository#existsByUserId(Long)}
     */
    @Test
    void testExistsByUserId() {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setUserId(1L);

        TrainingModel trainingModel2 = new TrainingModel();
        trainingModel2.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel2.setDistanceKm(-1);
        trainingModel2.setUserId(2L);
        trainingRepository.save(trainingModel);
        trainingRepository.save(trainingModel2);
        assertTrue(trainingRepository.existsByUserId(1L));
    }

    /**
     * Method under test: {@link TrainingRepository#findAllByUserId(Long)}
     */
    @Test
    void testFindAllByUserId() {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setUserId(1L);

        TrainingModel trainingModel2 = new TrainingModel();
        trainingModel2.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel2.setDistanceKm(-1);
        trainingModel2.setUserId(2L);
        trainingRepository.save(trainingModel);
        trainingRepository.save(trainingModel2);
        assertEquals(1, trainingRepository.findAllByUserId(1L).size());
    }
}

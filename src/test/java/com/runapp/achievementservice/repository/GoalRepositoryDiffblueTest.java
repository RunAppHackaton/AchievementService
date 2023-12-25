package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {GoalRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.runapp.achievementservice.model"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class GoalRepositoryDiffblueTest {
    @Autowired
    private GoalRepository goalRepository;

    @MockBean
    private SqlDataSourceScriptDatabaseInitializer sqlDataSourceScriptDatabaseInitializer;

    /**
     * Method under test: {@link GoalRepository#findAllByGoalTypeEnum(GoalTypeEnum)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAllByGoalTypeEnum() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.findAllByGoalTypeEnum(Unknown Source)
        //   java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:152)
        //       at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:378)
        //       at org.hibernate.query.Query.getResultList(Query.java:119)
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.findAllByGoalTypeEnum(Unknown Source)
        //   org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at org.hibernate.engine.spi.CascadingActions$8.noCascade(CascadingActions.java:372)
        //       at org.hibernate.engine.internal.Cascade.cascade(Cascade.java:169)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.cascadeOnFlush(AbstractFlushingEventListener.java:155)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.prepareEntityFlushes(AbstractFlushingEventListener.java:145)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.flushEverythingToExecutions(AbstractFlushingEventListener.java:79)
        //       at org.hibernate.event.internal.DefaultAutoFlushEventListener.onAutoFlush(DefaultAutoFlushEventListener.java:48)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.autoFlushIfRequired(SessionImpl.java:1375)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.lambda$new$0(ConcreteSqmSelectQueryPlan.java:108)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.withCacheableSqmInterpretation(ConcreteSqmSelectQueryPlan.java:303)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.performList(ConcreteSqmSelectQueryPlan.java:244)
        //       at org.hibernate.query.sqm.internal.QuerySqmImpl.doList(QuerySqmImpl.java:518)
        //       at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:367)
        //       at org.hibernate.query.Query.getResultList(Query.java:119)
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.findAllByGoalTypeEnum(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel goalModel = new GoalModel();
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId(1L);

        GoalStatusModel goalStatus2 = new GoalStatusModel();
        goalStatus2.setGoalModels(new ArrayList<>());
        goalStatus2.setStatusEnum(GoalStatusEnum.FINISHED);

        GoalTypeModel goalType2 = new GoalTypeModel();
        goalType2.setGoalModels(new ArrayList<>());
        goalType2.setGoalTypeEnum(GoalTypeEnum.AVERAGE_RUNNING_PACE);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setCompletionPercentage(0.5f);
        goalModel2.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setGoal("com.runapp.achievementservice.model.GoalModel");
        goalModel2.setGoalStatus(goalStatus2);
        goalModel2.setGoalType(goalType2);
        goalModel2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setUserId(2L);
        goalRepository.save(goalModel);
        goalRepository.save(goalModel2);
        goalRepository.findAllByGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);
    }

    /**
     * Method under test: {@link GoalRepository#existsByUserId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExistsByUserId() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.existsByUserId(Unknown Source)
        //   java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:152)
        //       at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:378)
        //       at org.hibernate.query.Query.getResultList(Query.java:119)
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.existsByUserId(Unknown Source)
        //   org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at org.hibernate.engine.spi.CascadingActions$8.noCascade(CascadingActions.java:372)
        //       at org.hibernate.engine.internal.Cascade.cascade(Cascade.java:169)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.cascadeOnFlush(AbstractFlushingEventListener.java:155)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.prepareEntityFlushes(AbstractFlushingEventListener.java:145)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.flushEverythingToExecutions(AbstractFlushingEventListener.java:79)
        //       at org.hibernate.event.internal.DefaultAutoFlushEventListener.onAutoFlush(DefaultAutoFlushEventListener.java:48)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.autoFlushIfRequired(SessionImpl.java:1375)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.lambda$new$0(ConcreteSqmSelectQueryPlan.java:108)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.withCacheableSqmInterpretation(ConcreteSqmSelectQueryPlan.java:303)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.performList(ConcreteSqmSelectQueryPlan.java:244)
        //       at org.hibernate.query.sqm.internal.QuerySqmImpl.doList(QuerySqmImpl.java:518)
        //       at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:367)
        //       at org.hibernate.query.Query.getResultList(Query.java:119)
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.existsByUserId(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel goalModel = new GoalModel();
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId(1L);

        GoalStatusModel goalStatus2 = new GoalStatusModel();
        goalStatus2.setGoalModels(new ArrayList<>());
        goalStatus2.setStatusEnum(GoalStatusEnum.FINISHED);

        GoalTypeModel goalType2 = new GoalTypeModel();
        goalType2.setGoalModels(new ArrayList<>());
        goalType2.setGoalTypeEnum(GoalTypeEnum.AVERAGE_RUNNING_PACE);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setCompletionPercentage(0.5f);
        goalModel2.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setGoal("com.runapp.achievementservice.model.GoalModel");
        goalModel2.setGoalStatus(goalStatus2);
        goalModel2.setGoalType(goalType2);
        goalModel2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setUserId(2L);
        goalRepository.save(goalModel);
        goalRepository.save(goalModel2);
        goalRepository.existsByUserId(1L);
    }

    /**
     * Method under test: {@link GoalRepository#findAllByUserId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAllByUserId() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.findAllByUserId(Unknown Source)
        //   java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:152)
        //       at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:378)
        //       at org.hibernate.query.Query.getResultList(Query.java:119)
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.findAllByUserId(Unknown Source)
        //   org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.runapp.achievementservice.model.GoalModel.goalStatus -> com.runapp.achievementservice.model.GoalStatusModel
        //       at org.hibernate.engine.spi.CascadingActions$8.noCascade(CascadingActions.java:372)
        //       at org.hibernate.engine.internal.Cascade.cascade(Cascade.java:169)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.cascadeOnFlush(AbstractFlushingEventListener.java:155)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.prepareEntityFlushes(AbstractFlushingEventListener.java:145)
        //       at org.hibernate.event.internal.AbstractFlushingEventListener.flushEverythingToExecutions(AbstractFlushingEventListener.java:79)
        //       at org.hibernate.event.internal.DefaultAutoFlushEventListener.onAutoFlush(DefaultAutoFlushEventListener.java:48)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.autoFlushIfRequired(SessionImpl.java:1375)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.lambda$new$0(ConcreteSqmSelectQueryPlan.java:108)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.withCacheableSqmInterpretation(ConcreteSqmSelectQueryPlan.java:303)
        //       at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.performList(ConcreteSqmSelectQueryPlan.java:244)
        //       at org.hibernate.query.sqm.internal.QuerySqmImpl.doList(QuerySqmImpl.java:518)
        //       at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:367)
        //       at org.hibernate.query.Query.getResultList(Query.java:119)
        //       at jdk.proxy5/jdk.proxy5.$Proxy190.findAllByUserId(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel goalModel = new GoalModel();
        goalModel.setCompletionPercentage(10.0f);
        goalModel.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setGoal("Goal");
        goalModel.setGoalStatus(goalStatus);
        goalModel.setGoalType(goalType);
        goalModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setUserId(1L);

        GoalStatusModel goalStatus2 = new GoalStatusModel();
        goalStatus2.setGoalModels(new ArrayList<>());
        goalStatus2.setStatusEnum(GoalStatusEnum.FINISHED);

        GoalTypeModel goalType2 = new GoalTypeModel();
        goalType2.setGoalModels(new ArrayList<>());
        goalType2.setGoalTypeEnum(GoalTypeEnum.AVERAGE_RUNNING_PACE);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setCompletionPercentage(0.5f);
        goalModel2.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setGoal("com.runapp.achievementservice.model.GoalModel");
        goalModel2.setGoalStatus(goalStatus2);
        goalModel2.setGoalType(goalType2);
        goalModel2.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setUserId(2L);
        goalRepository.save(goalModel);
        goalRepository.save(goalModel2);
        goalRepository.findAllByUserId(1L);
    }
}

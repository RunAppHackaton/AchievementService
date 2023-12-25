package com.runapp.achievementservice.repository;

import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;

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

@ContextConfiguration(classes = {AchievementRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.runapp.achievementservice.model"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class AchievementRepositoryDiffblueTest {
    @Autowired
    private AchievementRepository achievementRepository;

    @MockBean
    private SqlDataSourceScriptDatabaseInitializer sqlDataSourceScriptDatabaseInitializer;

    /**
     * Method under test: {@link AchievementRepository#findByStory_id(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByStory_id() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Naruszenie więzów integralności: "FKJNKLVTLGCSMRMS6SEK5RTJSKN: PUBLIC.ACHIEVEMENT FOREIGN KEY(RARITY_ID) REFERENCES PUBLIC.RARITY_MODEL(ID) (CAST(1 AS BIGINT))"
        //   Referential integrity constraint violation: "FKJNKLVTLGCSMRMS6SEK5RTJSKN: PUBLIC.ACHIEVEMENT FOREIGN KEY(RARITY_ID) REFERENCES PUBLIC.RARITY_MODEL(ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into achievement (achievement_image_url,description,name,rarity_id,story_id,id) values (?,?,?,?,?,default) [23506-214]] [insert into achievement (achievement_image_url,description,name,rarity_id,story_id,id) values (?,?,?,?,?,default)]; SQL [insert into achievement (achievement_image_url,description,name,rarity_id,story_id,id) values (?,?,?,?,?,default)]; constraint [FKJNKLVTLGCSMRMS6SEK5RTJSKN]
        //       at jdk.proxy4/jdk.proxy4.$Proxy170.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Naruszenie więzów integralności: "FKJNKLVTLGCSMRMS6SEK5RTJSKN: PUBLIC.ACHIEVEMENT FOREIGN KEY(RARITY_ID) REFERENCES PUBLIC.RARITY_MODEL(ID) (CAST(1 AS BIGINT))"
        //   Referential integrity constraint violation: "FKJNKLVTLGCSMRMS6SEK5RTJSKN: PUBLIC.ACHIEVEMENT FOREIGN KEY(RARITY_ID) REFERENCES PUBLIC.RARITY_MODEL(ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into achievement (achievement_image_url,description,name,rarity_id,story_id,id) values (?,?,?,?,?,default) [23506-214]] [insert into achievement (achievement_image_url,description,name,rarity_id,story_id,id) values (?,?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:60)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:56)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:278)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:101)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2757)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:674)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4/jdk.proxy4.$Proxy164.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy170.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Naruszenie więzów integralności: "FKJNKLVTLGCSMRMS6SEK5RTJSKN: PUBLIC.ACHIEVEMENT FOREIGN KEY(RARITY_ID) REFERENCES PUBLIC.RARITY_MODEL(ID) (CAST(1 AS BIGINT))"
        //   Referential integrity constraint violation: "FKJNKLVTLGCSMRMS6SEK5RTJSKN: PUBLIC.ACHIEVEMENT FOREIGN KEY(RARITY_ID) REFERENCES PUBLIC.RARITY_MODEL(ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into achievement (achievement_image_url,description,name,rarity_id,story_id,id) values (?,?,?,?,?,default) [23506-214]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:508)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1172)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1190)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:252)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:209)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:169)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:275)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:101)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2757)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:674)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4/jdk.proxy4.$Proxy164.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy170.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        RarityModel rarityModel = new RarityModel();
        rarityModel.setAchievementModelList(new ArrayList<>());
        rarityModel.setId(1L);
        rarityModel.setName("Name");

        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setAchievementImageUrl("https://example.org/example");
        achievementModel.setDescription("The characteristics of someone or something");
        achievementModel.setName("Name");
        achievementModel.setRarityModel(rarityModel);
        achievementModel.setStory_id(1);

        RarityModel rarityModel2 = new RarityModel();
        rarityModel2.setAchievementModelList(new ArrayList<>());
        rarityModel2.setId(2L);
        rarityModel2.setName("com.runapp.achievementservice.model.RarityModel");

        AchievementModel achievementModel2 = new AchievementModel();
        achievementModel2.setAchievementImageUrl("Achievement Image Url");
        achievementModel2.setDescription("Description");
        achievementModel2.setName("com.runapp.achievementservice.model.AchievementModel");
        achievementModel2.setRarityModel(rarityModel2);
        achievementModel2.setStory_id(2);
        achievementRepository.save(achievementModel);
        achievementRepository.save(achievementModel2);
        achievementRepository.findByStory_id(1);
    }
}

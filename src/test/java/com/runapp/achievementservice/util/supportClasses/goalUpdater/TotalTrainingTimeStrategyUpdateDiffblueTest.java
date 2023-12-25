package com.runapp.achievementservice.util.supportClasses.goalUpdater;

import static org.mockito.Mockito.when;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.model.UserStatisticModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.repository.UserStatisticRepository;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TotalTrainingTimeStrategyUpdate.class})
@ExtendWith(SpringExtension.class)
class TotalTrainingTimeStrategyUpdateDiffblueTest {
    @MockBean
    private GoalRepository goalRepository;

    @Autowired
    private TotalTrainingTimeStrategyUpdate totalTrainingTimeStrategyUpdate;

    @MockBean
    private UserStatisticRepository userStatisticRepository;

    /**
     * Method under test:
     * {@link TotalTrainingTimeStrategyUpdate#updateGoal(GoalModel, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateGoal() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.time.format.DateTimeParseException: Text 'Goal' could not be parsed at index 0
        //       at java.base/java.time.format.DateTimeFormatter.parseResolved0(DateTimeFormatter.java:2106)
        //       at java.base/java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:2008)
        //       at java.base/java.time.LocalTime.parse(LocalTime.java:473)
        //       at com.runapp.achievementservice.util.supportClasses.goalUpdater.TotalTrainingTimeStrategyUpdate.parseGoalStringToDuration(TotalTrainingTimeStrategyUpdate.java:46)
        //       at com.runapp.achievementservice.util.supportClasses.goalUpdater.TotalTrainingTimeStrategyUpdate.updateGoal(TotalTrainingTimeStrategyUpdate.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        UserStatisticModel userStatisticModel = new UserStatisticModel();
        userStatisticModel.setNumberOfTrainingSessionsOverTime(1L);
        userStatisticModel.setNumberOfWorkoutsPerMonth(1L);
        userStatisticModel.setNumberOfWorkoutsPerWeek(1L);
        userStatisticModel.setNumberOfWorkoutsPerYear(1L);
        userStatisticModel.setTotalNumberOfWorkoutsForAllTime(1L);
        userStatisticModel.setUserId(1L);
        Optional<UserStatisticModel> ofResult = Optional.of(userStatisticModel);
        when(userStatisticRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        GoalStatusModel goalStatus = new GoalStatusModel();
        goalStatus.setGoalModels(new ArrayList<>());
        goalStatus.setStatusEnum(GoalStatusEnum.IN_PROGRESS);

        GoalTypeModel goalType = new GoalTypeModel();
        goalType.setGoalModels(new ArrayList<>());
        goalType.setGoalTypeEnum(GoalTypeEnum.TOTAL_TRAINING_TIME);

        GoalModel model = new GoalModel();
        model.setCompletionPercentage(10.0f);
        model.setFinishedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setGoal("Goal");
        model.setGoalStatus(goalStatus);
        model.setGoalType(goalType);
        model.setId(1L);
        model.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setUserId(1L);
        totalTrainingTimeStrategyUpdate.updateGoal(model, new ArrayList<>());
    }
}

package com.runapp.achievementservice.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.model.GoalStatusModel;
import com.runapp.achievementservice.model.GoalTypeModel;
import com.runapp.achievementservice.repository.GoalRepository;
import com.runapp.achievementservice.staticObject.StaticGoal;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GoalServiceImpl.class})
@ExtendWith(SpringExtension.class)
class GoalServiceImplDiffblueTest {
    @MockBean
    private GoalRepository goalRepository;

    @Autowired
    private GoalServiceImpl goalServiceImpl;

    /**
     * Method under test: {@link GoalServiceImpl#add(GoalModel)}
     */
    @Test
    void testAdd() {
        GoalModel goalModel = StaticGoal.goalModel1();
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel);

        GoalModel entity = StaticGoal.goalModel1();
        GoalModel actualAddResult = goalServiceImpl.add(entity);
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertSame(goalModel, actualAddResult);
    }

    /**
     * Method under test: {@link GoalServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        GoalModel goalModel = StaticGoal.goalModel1();
        Optional<GoalModel> ofResult = Optional.of(goalModel);
        when(goalRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        GoalModel actualById = goalServiceImpl.getById(1L);
        verify(goalRepository).findById(Mockito.<Long>any());
        assertSame(goalModel, actualById);
    }

    /**
     * Method under test: {@link GoalServiceImpl#getById(Long)}
     */
    @Test
    void testGetById2() {
        Optional<GoalModel> emptyResult = Optional.empty();
        when(goalRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(NoEntityFoundException.class, () -> goalServiceImpl.getById(1L));
        verify(goalRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalServiceImpl#getById(Long)}
     */
    @Test
    void testGetById3() {
        when(goalRepository.findById(Mockito.<Long>any())).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> goalServiceImpl.getById(1L));
        verify(goalRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<GoalModel> goalModelList = new ArrayList<>();
        when(goalRepository.findAll()).thenReturn(goalModelList);
        List<GoalModel> actualAll = goalServiceImpl.getAll();
        verify(goalRepository).findAll();
        assertTrue(actualAll.isEmpty());
        assertSame(goalModelList, actualAll);
    }

    /**
     * Method under test: {@link GoalServiceImpl#getAll()}
     */
    @Test
    void testGetAll2() {
        when(goalRepository.findAll()).thenThrow(new NoEntityFoundException("An error occurred"));
        assertThrows(NoEntityFoundException.class, () -> goalServiceImpl.getAll());
        verify(goalRepository).findAll();
    }

    /**
     * Method under test: {@link GoalServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(goalRepository).deleteById(Mockito.<Long>any());
        when(goalRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        goalServiceImpl.deleteById(1L);
        verify(goalRepository).deleteById(Mockito.<Long>any());
        verify(goalRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById2() {
        doThrow(new NoEntityFoundException("An error occurred")).when(goalRepository).deleteById(Mockito.<Long>any());
        when(goalRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        assertThrows(NoEntityFoundException.class, () -> goalServiceImpl.deleteById(1L));
        verify(goalRepository).deleteById(Mockito.<Long>any());
        verify(goalRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById3() {
        when(goalRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        assertThrows(NoEntityFoundException.class, () -> goalServiceImpl.deleteById(1L));
        verify(goalRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GoalServiceImpl#update(GoalModel)}
     */
    @Test
    void testUpdate() {
        GoalModel goalModel = StaticGoal.goalModel1();
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel);
        when(goalRepository.existsById(Mockito.<Long>any())).thenReturn(true);

        GoalModel entity = StaticGoal.goalModel1();
        GoalModel actualUpdateResult = goalServiceImpl.update(entity);
        verify(goalRepository).existsById(Mockito.<Long>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertSame(goalModel, actualUpdateResult);
    }

    /**
     * Method under test: {@link GoalServiceImpl#update(GoalModel)}
     */

    @Test
    void testUpdate3() {
        when(goalRepository.existsById(Mockito.<Long>any())).thenReturn(false);

        GoalModel entity = StaticGoal.goalModel1();
        assertThrows(NoEntityFoundException.class, () -> goalServiceImpl.update(entity));
        verify(goalRepository).existsById(Mockito.<Long>any());
    }
}

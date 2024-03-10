package com.runapp.achievementservice.dto.dtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.runapp.achievementservice.staticObject.StaticTraining;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrainingDtoMapper.class, TrainingRequest.class})
@ExtendWith(SpringExtension.class)
class TrainingDtoMapperDiffblueTest {
    @Autowired
    private TrainingDtoMapper trainingDtoMapper;

    @Autowired
    private TrainingRequest trainingRequest;

    /**
     * Method under test: {@link TrainingDtoMapper#toModel(TrainingRequest)}
     */
    @Test
    void testToModel() {
        TrainingModel actualToModelResult = trainingDtoMapper.toModel(trainingRequest);
        assertNull(actualToModelResult.getUserId());
        assertNull(actualToModelResult.getAveragePace());
        assertNull(actualToModelResult.getDuration());
        assertNull(actualToModelResult.getDateTraining());
        assertEquals(0, actualToModelResult.getDistanceKm().intValue());
    }

    /**
     * Method under test: {@link TrainingDtoMapper#toResponse(TrainingModel)}
     */
    @Test
    void testToResponse() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();
        TrainingResponse actualToResponseResult = trainingDtoMapper.toResponse(trainingModel);
        assertEquals("1970-01-01", actualToResponseResult.getTraining_date().toString());
        assertNull(actualToResponseResult.getPace());
        assertNull(actualToResponseResult.getTraining_duration());
        assertEquals(1, actualToResponseResult.getDistance_km());
        assertEquals("1", actualToResponseResult.getUserId());
    }

    /**
     * Method under test: {@link TrainingDtoMapper#toResponse(TrainingModel)}
     */
    @Test
    void testToResponse2() {
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingModel.getDistanceKm()).thenReturn(1);
        when(trainingModel.getUserId()).thenReturn("1");
        when(trainingModel.getAveragePace()).thenReturn(null);
        when(trainingModel.getDuration()).thenReturn(null);
        when(trainingModel.getDateTraining()).thenReturn(LocalDate.of(1970, 1, 1));
        doNothing().when(trainingModel).setDateTraining(Mockito.<LocalDate>any());
        doNothing().when(trainingModel).setDistanceKm(Mockito.<Integer>any());
        doNothing().when(trainingModel).setId(Mockito.<Long>any());
        doNothing().when(trainingModel).setUserId(Mockito.<String>any());
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId("1");
        TrainingResponse actualToResponseResult = trainingDtoMapper.toResponse(trainingModel);
        verify(trainingModel).getAveragePace();
        verify(trainingModel).getDateTraining();
        verify(trainingModel).getDistanceKm();
        verify(trainingModel).getDuration();
        verify(trainingModel).getUserId();
        verify(trainingModel).setDateTraining(Mockito.<LocalDate>any());
        verify(trainingModel).setDistanceKm(Mockito.<Integer>any());
        verify(trainingModel).setId(Mockito.<Long>any());
        verify(trainingModel).setUserId(Mockito.<String>any());
        assertEquals("1970-01-01", actualToResponseResult.getTraining_date().toString());
        assertNull(actualToResponseResult.getPace());
        assertNull(actualToResponseResult.getTraining_duration());
        assertEquals(1, actualToResponseResult.getDistance_km());
        assertEquals("1", actualToResponseResult.getUserId());
    }

    /**
     * Method under test: {@link TrainingDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList() {
        assertTrue(trainingDtoMapper.toResponseList(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link TrainingDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList2() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();

        ArrayList<TrainingModel> trainingModels = new ArrayList<>();
        trainingModels.add(trainingModel);
        List<TrainingResponse> actualToResponseListResult = trainingDtoMapper.toResponseList(trainingModels);
        assertEquals(1, actualToResponseListResult.size());
        TrainingResponse getResult = actualToResponseListResult.get(0);
        assertEquals("1970-01-01", getResult.getTraining_date().toString());
        assertNull(getResult.getPace());
        assertNull(getResult.getTraining_duration());
        assertEquals(1, getResult.getDistance_km());
        assertEquals("1", getResult.getUserId());
    }

    /**
     * Method under test: {@link TrainingDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList3() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();

        TrainingModel trainingModel2 = StaticTraining.trainingModel2();

        ArrayList<TrainingModel> trainingModels = new ArrayList<>();
        trainingModels.add(trainingModel2);
        trainingModels.add(trainingModel);
        List<TrainingResponse> actualToResponseListResult = trainingDtoMapper.toResponseList(trainingModels);
        assertEquals(2, actualToResponseListResult.size());
        TrainingResponse getResult = actualToResponseListResult.get(0);
        assertEquals("1970-01-01", getResult.getTraining_date().toString());
        TrainingResponse getResult2 = actualToResponseListResult.get(1);
        assertEquals("1970-01-01", getResult2.getTraining_date().toString());
        assertNull(getResult.getPace());
        assertNull(getResult2.getPace());
        assertNull(getResult.getTraining_duration());
        assertNull(getResult2.getTraining_duration());
        assertEquals(-1, getResult.getDistance_km());
        assertEquals(1, getResult2.getDistance_km());
        assertEquals("1", getResult2.getUserId());
        assertEquals("2", getResult.getUserId());
    }

    /**
     * Method under test: {@link TrainingDtoMapper#toResponseList(List)}
     */
    @Test
    void testToResponseList4() {
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingModel.getDistanceKm()).thenReturn(1);
        when(trainingModel.getUserId()).thenReturn("1");
        when(trainingModel.getAveragePace()).thenReturn(null);
        when(trainingModel.getDuration()).thenReturn(null);
        when(trainingModel.getDateTraining()).thenReturn(LocalDate.of(1970, 1, 1));
        doNothing().when(trainingModel).setDateTraining(Mockito.<LocalDate>any());
        doNothing().when(trainingModel).setDistanceKm(Mockito.<Integer>any());
        doNothing().when(trainingModel).setId(Mockito.<Long>any());
        doNothing().when(trainingModel).setUserId(Mockito.<String>any());
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId("1");

        ArrayList<TrainingModel> trainingModels = new ArrayList<>();
        trainingModels.add(trainingModel);
        List<TrainingResponse> actualToResponseListResult = trainingDtoMapper.toResponseList(trainingModels);
        verify(trainingModel).getAveragePace();
        verify(trainingModel).getDateTraining();
        verify(trainingModel).getDistanceKm();
        verify(trainingModel).getDuration();
        verify(trainingModel).getUserId();
        verify(trainingModel).setDateTraining(Mockito.<LocalDate>any());
        verify(trainingModel).setDistanceKm(Mockito.<Integer>any());
        verify(trainingModel).setId(Mockito.<Long>any());
        verify(trainingModel).setUserId(Mockito.<String>any());
        assertEquals(1, actualToResponseListResult.size());
        TrainingResponse getResult = actualToResponseListResult.get(0);
        assertEquals("1970-01-01", getResult.getTraining_date().toString());
        assertNull(getResult.getPace());
        assertNull(getResult.getTraining_duration());
        assertEquals(1, getResult.getDistance_km());
        assertEquals("1", getResult.getUserId());
    }
}

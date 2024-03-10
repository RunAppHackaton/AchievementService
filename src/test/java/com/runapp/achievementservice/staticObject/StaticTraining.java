package com.runapp.achievementservice.staticObject;

import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.model.TrainingModel;

import java.time.LocalDate;

public class StaticTraining {
    public static TrainingModel trainingModel1(){
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel.setDistanceKm(1);
        trainingModel.setId(1L);
        trainingModel.setUserId("1");

        return trainingModel;
    }

    public static TrainingModel trainingModel2(){
        TrainingModel trainingModel2 = new TrainingModel();
        trainingModel2.setDateTraining(LocalDate.of(1970, 1, 1));
        trainingModel2.setDistanceKm(-1);
        trainingModel2.setUserId("2");

        return trainingModel2;
    }

    public static TrainingRequest trainingRequest(){
        TrainingRequest trainingRequest2 = new TrainingRequest();
        trainingRequest2.setDistance_km(1);
        trainingRequest2.setTraining_date(null);
        trainingRequest2.setUserId("2");
        return trainingRequest2;
    }
}

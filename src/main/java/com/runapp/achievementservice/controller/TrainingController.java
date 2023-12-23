package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.dto.dtoMapper.DtoMapper;
import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.service.TrainingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainings")
@AllArgsConstructor
@Tag(name = "Training Management", description = "Operations related to training")
public class TrainingController {

    private final TrainingService trainingService;
    private final DtoMapper<TrainingModel, TrainingRequest, TrainingResponse> trainingDtoMapper;

    @Operation(
            summary = "Create a new training",
            description = "Create a new training with the provided data",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = TrainingRequest.class))),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Training created", content = @Content(schema = @Schema(implementation = TrainingResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    @PostMapping
    public ResponseEntity<TrainingResponse> saveTraining(@RequestBody @Valid TrainingRequest trainingRequest) {
        TrainingModel trainingModel = trainingService.saveTraining(trainingDtoMapper.toModel(trainingRequest));
        TrainingResponse trainingResponse = trainingDtoMapper.toResponse(trainingModel);
        return new ResponseEntity<>(trainingResponse, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get a training by ID",
            description = "Retrieve a training by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Training found", content = @Content(schema = @Schema(implementation = TrainingResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Training not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<TrainingResponse> getTrainingById(@PathVariable Integer id) {
        TrainingModel trainingModel = trainingService.getTrainingById(id);
        TrainingResponse trainingResponse = trainingDtoMapper.toResponse(trainingModel);
        return ResponseEntity.ok(trainingResponse);
    }

    @Operation(
            summary = "Get all trainings",
            description = "Retrieve a list of all trainings",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Trainings found", content = @Content(schema = @Schema(implementation = TrainingResponse.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<TrainingResponse>> getAllTrainings() {
        List<TrainingModel> trainingModels = trainingService.getAllTrainings();
        List<TrainingResponse> trainingResponses = trainingDtoMapper.toResponseList(trainingModels);
        return ResponseEntity.ok(trainingResponses);
    }

    @Operation(
            summary = "Delete a training by ID",
            description = "Delete a training by its ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Training deleted"),
                    @ApiResponse(responseCode = "404", description = "Training not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingById(@PathVariable Integer id) {
        trainingService.deleteTrainingById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Get all trainings by user ID",
            description = "Retrieve a list of all trainings for a specific user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Trainings found", content = @Content(schema = @Schema(implementation = TrainingResponse.class)))
            }
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TrainingResponse>> getAllTrainingsByUserId(@PathVariable Long userId) {
        List<TrainingModel> trainingModels = trainingService.getAllTrainingsByUserId(userId);
        List<TrainingResponse> trainingResponses = trainingDtoMapper.toResponseList(trainingModels);
        return ResponseEntity.ok(trainingResponses);
    }
}
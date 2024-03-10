package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.dto.dtoMapper.DtoMapper;
import com.runapp.achievementservice.dto.request.TrainingRequest;
import com.runapp.achievementservice.dto.response.TrainingResponse;
import com.runapp.achievementservice.model.TrainingModel;
import com.runapp.achievementservice.service.serviceImpl.TrainingServiceImpl;
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

    private final TrainingServiceImpl trainingServiceImpl;
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
    public ResponseEntity<TrainingResponse> saveTraining(@RequestBody @Valid TrainingRequest trainingRequest, @RequestHeader("X-UserId") String userId) {
        TrainingModel trainingModel = trainingServiceImpl.add(trainingDtoMapper.toModel(trainingRequest));
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
    public ResponseEntity<TrainingResponse> getTrainingById(@PathVariable Long id) {
        TrainingModel trainingModel = trainingServiceImpl.getById(id);
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
        List<TrainingModel> trainingModels = trainingServiceImpl.getAll();
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
    public ResponseEntity<Void> deleteTrainingById(@PathVariable Long id) {
        trainingServiceImpl.deleteById(id);
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
    public ResponseEntity<List<TrainingResponse>> getAllTrainingsByUserId(@PathVariable String userId) {
        List<TrainingModel> trainingModels = trainingServiceImpl.getAllTrainingsByUserId(userId);
        List<TrainingResponse> trainingResponses = trainingDtoMapper.toResponseList(trainingModels);
        return ResponseEntity.ok(trainingResponses);
    }
}
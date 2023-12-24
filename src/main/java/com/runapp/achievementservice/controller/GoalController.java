package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.dto.dtoMapper.DtoMapper;
import com.runapp.achievementservice.dto.request.GoalRequest;
import com.runapp.achievementservice.dto.response.GoalResponse;
import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.service.serviceImpl.GoalServiceImpl;
import com.runapp.achievementservice.util.enums.GoalStatusEnum;
import com.runapp.achievementservice.util.enums.GoalTypeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
@AllArgsConstructor
@Tag(name = "Goal Management", description = "Operations related to goals")
public class GoalController {

    private final GoalServiceImpl goalServiceImpl;
    private final DtoMapper<GoalModel, GoalRequest, GoalResponse> goalDtoMapper;




    @Operation(
            summary = "Get all goals",
            description = "Retrieve a list of all goals",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goals found", content = @Content(schema = @Schema(implementation = GoalResponse.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<GoalResponse>> getAllGoals() {
        List<GoalResponse> responses = goalDtoMapper.toResponseList(goalServiceImpl.getAll());
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }



    @Operation(
            summary = "Get a goal by ID",
            description = "Retrieve a goal by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goal found", content = @Content(schema = @Schema(implementation = GoalResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Goal not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<GoalResponse> getGoalById(@PathVariable long id) {
        GoalResponse goalResponse = goalDtoMapper.toResponse(goalServiceImpl.getById(id));
        return new ResponseEntity<>(goalResponse, HttpStatus.OK);
    }



    @Operation(
            summary = "Create a new goal",
            description = "Create a new goal with the provided data",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = GoalRequest.class))),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Goal created", content = @Content(schema = @Schema(implementation = GoalResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    @PostMapping
    public ResponseEntity<GoalResponse> saveGoal(@RequestBody GoalRequest goalRequest) {
        GoalModel goalModel = goalServiceImpl.add(goalDtoMapper.toModel(goalRequest));
        GoalResponse goalResponse = goalDtoMapper.toResponse(goalModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(goalResponse);
    }



    @Operation(
            summary = "Update a goal by ID",
            description = "Update an existing goal with the provided data",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = GoalRequest.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goal updated", content = @Content(schema = @Schema(implementation = GoalResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "404", description = "Goal not found")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<GoalResponse> updateGoal(@PathVariable long id, @RequestBody GoalModel updatedGoal) {
        updatedGoal.setId(id);
        GoalResponse goalResponse = goalDtoMapper.toResponse(goalServiceImpl.update(updatedGoal));
        return new ResponseEntity<>(goalResponse, HttpStatus.OK);
    }



    @Operation(
            summary = "Delete a goal by ID",
            description = "Delete a goal by its ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Goal deleted"),
                    @ApiResponse(responseCode = "404", description = "Goal not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable long id) {
        goalServiceImpl.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @Operation(
            summary = "Get all Goal Type Enums",
            description = "Retrieve all available Goal Type Enums",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goal Type Enums retrieved successfully", content = @Content(schema = @Schema(implementation = GoalTypeEnum[].class)))
            }
    )
    @GetMapping("/goal-type-enums")
    public ResponseEntity<GoalTypeEnum[]> getAllGoalTypeEnums() {
        return new ResponseEntity<>(GoalTypeEnum.values(), HttpStatus.OK);
    }



    @Operation(
            summary = "Get all Goal Status Enums",
            description = "Retrieve all available Goal Status Enums",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goal Status Enums retrieved successfully", content = @Content(schema = @Schema(implementation = GoalStatusEnum[].class)))
            }
    )
    @GetMapping("/goal-status-enums")
    public ResponseEntity<GoalStatusEnum[]> getAllGoalStatusEnums() {
        return new ResponseEntity<>(GoalStatusEnum.values(), HttpStatus.OK);
    }
}
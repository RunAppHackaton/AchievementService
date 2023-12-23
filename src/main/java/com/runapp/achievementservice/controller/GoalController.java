package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.service.GoalService;
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

    private final GoalService goalService;

    @Operation(
            summary = "Get all goals",
            description = "Retrieve a list of all goals",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goals found", content = @Content(schema = @Schema(implementation = GoalModel.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<GoalModel>> getAllGoals() {
        List<GoalModel> goals = goalService.getAllGoals();
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @Operation(
            summary = "Get a goal by ID",
            description = "Retrieve a goal by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goal found", content = @Content(schema = @Schema(implementation = GoalModel.class))),
                    @ApiResponse(responseCode = "404", description = "Goal not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<GoalModel> getGoalById(@PathVariable int id) {
        GoalModel goal = goalService.getGoalById(id);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @Operation(
            summary = "Create a new goal",
            description = "Create a new goal with the provided data",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = GoalModel.class))),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Goal created", content = @Content(schema = @Schema(implementation = GoalModel.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    @PostMapping
    public ResponseEntity<GoalModel> saveGoal(@RequestBody GoalModel goal) {
        GoalModel savedGoal = goalService.saveGoal(goal);
        return new ResponseEntity<>(savedGoal, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update a goal by ID",
            description = "Update an existing goal with the provided data",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = GoalModel.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Goal updated", content = @Content(schema = @Schema(implementation = GoalModel.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "404", description = "Goal not found")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<GoalModel> updateGoal(@PathVariable int id, @RequestBody GoalModel updatedGoal) {
        updatedGoal.setId(id);
        GoalModel goal = goalService.updateGoal(updatedGoal);
        return new ResponseEntity<>(goal, HttpStatus.OK);
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
    public ResponseEntity<Void> deleteGoal(@PathVariable int id) {
        goalService.deleteGoalById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
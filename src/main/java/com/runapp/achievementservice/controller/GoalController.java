package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.model.GoalModel;
import com.runapp.achievementservice.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
@AllArgsConstructor
public class GoalController {

    private final GoalService goalService; //todo переделать под dto mapper

    @GetMapping
    public ResponseEntity<List<GoalModel>> getAllGoals() {
        List<GoalModel> goals = goalService.getAllGoals();
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalModel> getGoalById(@PathVariable int id) {
        GoalModel goal = goalService.getGoalById(id);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GoalModel> saveGoal(@RequestBody GoalModel goal) {
        GoalModel savedGoal = goalService.saveGoal(goal);
        return new ResponseEntity<>(savedGoal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalModel> updateGoal(@PathVariable int id, @RequestBody GoalModel updatedGoal) {
        updatedGoal.setId(id);
        GoalModel goal = goalService.updateGoal(updatedGoal);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable int id) {
        goalService.deleteGoalById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

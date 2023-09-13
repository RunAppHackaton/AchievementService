package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.dto.request.RarityRequest;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.service.RarityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rarities")
@Tag(name = "Rarity Management", description = "Operations related to rarities")
public class RarityController {
    private final RarityService rarityService;

    @Autowired
    public RarityController(RarityService rarityService) {
        this.rarityService = rarityService;
    }

    @PostMapping
    @Operation(summary = "Create a new rarity", description = "Create a new rarity with the provided data")
    @ApiResponse(responseCode = "201", description = "Rarity created", content = @Content(schema = @Schema(implementation = RarityModel.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public ResponseEntity<RarityModel> createRarity(
            @Parameter(description = "Rarity data", required = true)
            @RequestBody RarityRequest rarityRequest) {
        RarityModel createdRarity = rarityService.createRarity(rarityRequest.toRarityModel());
        return new ResponseEntity<>(createdRarity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a rarity by ID", description = "Retrieve a rarity by its ID")
    @ApiResponse(responseCode = "200", description = "Rarity found", content = @Content(schema = @Schema(implementation = RarityModel.class)))
    @ApiResponse(responseCode = "404", description = "Rarity not found")
    public ResponseEntity<Optional<RarityModel>> getRarityById(
            @Parameter(description = "Rarity ID", required = true)
            @PathVariable int id) {
        Optional<RarityModel> rarity = rarityService.getRarityById(id);
        if (rarity.isPresent()) {
            return new ResponseEntity<>(rarity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a rarity", description = "Update an existing rarity with the provided data")
    @ApiResponse(responseCode = "200", description = "Rarity updated", content = @Content(schema = @Schema(implementation = RarityModel.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Rarity not found")
    public ResponseEntity<RarityModel> updateRarity(
            @Parameter(description = "Updated rarity data", required = true)
            @PathVariable int id,
            @RequestBody RarityRequest rarityRequest) {
        Optional<RarityModel> existingRarity = rarityService.getRarityById(id);
        if (existingRarity.isPresent()) {
            RarityModel rarityModel = rarityRequest.toRarityModel();
            rarityModel.setId(id);
            RarityModel updatedRarity = rarityService.updateRarity(rarityModel);
            return new ResponseEntity<>(updatedRarity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a rarity", description = "Delete a rarity by its ID")
    @ApiResponse(responseCode = "204", description = "Rarity deleted")
    @ApiResponse(responseCode = "404", description = "Rarity not found")
    public ResponseEntity<Void> deleteRarity(
            @Parameter(description = "Rarity ID", required = true)
            @PathVariable int id) {
        Optional<RarityModel> existingRarity = rarityService.getRarityById(id);
        if (existingRarity.isPresent()) {
            rarityService.deleteRarity(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Get all rarities", description = "Retrieve a list of all rarities")
    public ResponseEntity<List<RarityModel>> getAllRarities() {
        List<RarityModel> rarities = rarityService.getAllRarities();
        return new ResponseEntity<>(rarities, HttpStatus.OK);
    }
}

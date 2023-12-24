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
    public ResponseEntity<RarityModel> createRarity(@RequestBody RarityRequest rarityRequest) {
        RarityModel createdRarity = rarityService.add(rarityRequest.toRarityModel());
        return new ResponseEntity<>(createdRarity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a rarity by ID", description = "Retrieve a rarity by its ID")
    @ApiResponse(responseCode = "200", description = "Rarity found", content = @Content(schema = @Schema(implementation = RarityModel.class)))
    @ApiResponse(responseCode = "404", description = "Rarity not found")
    public ResponseEntity<RarityModel> getRarityById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rarityService.getById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a rarity", description = "Update an existing rarity with the provided data")
    @ApiResponse(responseCode = "200", description = "Rarity updated", content = @Content(schema = @Schema(implementation = RarityModel.class)))
    @ApiResponse(responseCode = "404", description = "Rarity not found")
    public ResponseEntity<RarityModel> updateRarity(
            @Parameter(description = "Rarity ID", required = true) @PathVariable Long id,
            @RequestBody RarityRequest rarityRequest) {
        RarityModel model = rarityService.update(rarityRequest.toRarityModel());
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a rarity", description = "Delete a rarity by its ID")
    @ApiResponse(responseCode = "204", description = "Rarity deleted")
    @ApiResponse(responseCode = "404", description = "Rarity not found")
    public ResponseEntity<Void> deleteRarity(@PathVariable Long id) {
        rarityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @Operation(summary = "Get all rarities", description = "Retrieve a list of all rarities")
    public ResponseEntity<List<RarityModel>> getAllRarities() {
        List<RarityModel> rarities = rarityService.getAll();
        return new ResponseEntity<>(rarities, HttpStatus.OK);
    }
}

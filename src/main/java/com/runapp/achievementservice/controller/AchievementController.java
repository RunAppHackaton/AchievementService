package com.runapp.achievementservice.controller;

import com.runapp.achievementservice.dto.request.AchievementDeleteRequest;
import com.runapp.achievementservice.dto.request.AchievementRequest;
import com.runapp.achievementservice.dto.request.DeleteStorageRequest;
import com.runapp.achievementservice.dto.response.DeleteResponse;
import com.runapp.achievementservice.dto.response.StoryResponse;
import com.runapp.achievementservice.feignService.StorageServiceClient;
import com.runapp.achievementservice.feignService.StoryManagementServiceClient;
import com.runapp.achievementservice.model.AchievementModel;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.service.serviceImpl.AchievementServiceImpl;
import com.runapp.achievementservice.service.serviceImpl.RarityService;
import feign.FeignException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/achievements")
@Tag(name = "Achievement Management", description = "Operations related to achievements")
public class AchievementController {
    private final AchievementServiceImpl achievementServiceImpl;

    @Value("${storage-directory}")
    private String storageDirectory;

    @Autowired
    private StorageServiceClient storageServiceClient;
    private final StoryManagementServiceClient storyManagementServiceClient;
    private final RarityService rarityService;

    @Autowired
    public AchievementController(StoryManagementServiceClient storyManagementServiceClient,
                                 RarityService rarityService,
                                 AchievementServiceImpl achievementServiceImpl) {

        this.achievementServiceImpl = achievementServiceImpl;
        this.storyManagementServiceClient = storyManagementServiceClient;
        this.rarityService = rarityService;
    }

    @Operation(summary = "Create a new achievement", description = "Create a new achievement with the provided data")
    @ApiResponse(responseCode = "201", description = "Achievement created", content = @Content(schema = @Schema(implementation = AchievementModel.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public ResponseEntity<Object> createAchievement(@RequestBody AchievementRequest achievementRequest) {
        try {
            ResponseEntity<StoryResponse> storyResponseEntity = storyManagementServiceClient.getStoryById(achievementRequest.getStory_id());

            RarityModel rarityModel = rarityService.getById(achievementRequest.getRarity_id());
            if (rarityModel == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("rarity with id " + achievementRequest.getRarity_id() + " not found");
            AchievementModel createdAchievement = achievementServiceImpl.createAchievement(achievementRequest.ToAchievementModel(rarityModel));
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAchievement);
        } catch (FeignException.NotFound e) {
            // Обработка 404 ошибки от удаленного сервиса
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("story with id " + achievementRequest.getStory_id() + " not found");
        }
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get an achievement by ID", description = "Retrieve an achievement by its ID")
    @ApiResponse(responseCode = "200", description = "Achievement found", content = @Content(schema = @Schema(implementation = AchievementModel.class)))
    @ApiResponse(responseCode = "404", description = "Achievement not found")
    public ResponseEntity<Optional<AchievementModel>> getAchievementById(@Parameter(description = "Achievement ID", required = true) @PathVariable int id) {
        Optional<AchievementModel> achievement = achievementServiceImpl.getAchievementById(id);
        if (achievement.isPresent()) {
            return new ResponseEntity<>(achievement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an achievement", description = "Update an existing achievement with the provided data")
    @ApiResponse(responseCode = "200", description = "Achievement updated", content = @Content(schema = @Schema(implementation = AchievementModel.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Achievement not found")
    public ResponseEntity<Object> updateAchievement(@Parameter(description = "Achievement ID", required = true) @PathVariable int id,
                                                    @RequestBody AchievementRequest achievementRequest) {
        try {
            ResponseEntity<StoryResponse> storyResponseEntity = storyManagementServiceClient.getStoryById(achievementRequest.getStory_id());
            Optional<AchievementModel> existingAchievement = achievementServiceImpl.getAchievementById(id);
            if (existingAchievement.isPresent()) {
                RarityModel rarityModel = rarityService.getById(achievementRequest.getRarity_id());
                if (rarityModel == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                AchievementModel createdAchievement = existingAchievement.orElse(null);
                createdAchievement.setId(id);
                createdAchievement.setStory_id(achievementRequest.getStory_id());
                AchievementModel updatedAchievement = achievementServiceImpl.updateAchievement(createdAchievement);
                return ResponseEntity.status(HttpStatus.OK).body(updatedAchievement);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("achievement with id " + id + " not found");
            }
        } catch (FeignException.NotFound e) {
            // Обработка 404 ошибки от удаленного сервиса
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("story with id " + achievementRequest.getStory_id() + " not found");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an achievement", description = "Delete an achievement by its ID")
    @ApiResponse(responseCode = "204", description = "Achievement deleted")
    @ApiResponse(responseCode = "404", description = "Achievement not found")
    public ResponseEntity<Void> deleteAchievement(@Parameter(description = "Achievement ID", required = true)
                                                  @PathVariable int id) {
        Optional<AchievementModel> existingAchievement = achievementServiceImpl.getAchievementById(id);
        if (existingAchievement.isPresent()) {
            achievementServiceImpl.deleteAchievement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-story/{storyId}")
    @Operation(summary = "Get achievements by story ID", description = "Retrieve a list of achievements for a specific story")
    @ApiResponse(responseCode = "200", description = "Achievements found", content = @Content(schema = @Schema(implementation = AchievementModel.class)))
    @ApiResponse(responseCode = "404", description = "Story not found")
    public ResponseEntity<List<AchievementModel>> getAchievementsByStoryId(@Parameter(description = "Story ID", required = true) @PathVariable int storyId) {
        List<AchievementModel> achievements = achievementServiceImpl.getAchievementsByStoryId(storyId);
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get all achievements", description = "Retrieve a list of all achievements")
    @ApiResponse(responseCode = "200", description = "Achievements found", content = @Content(schema = @Schema(implementation = AchievementModel.class)))
    public ResponseEntity<List<AchievementModel>> getAllRarities() {
        List<AchievementModel> achievements = achievementServiceImpl.getAllAchievements();
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }

    @PostMapping("/upload-image")
    @Operation(summary = "Upload an image for an achievement", description = "Upload an image file for a specific achievement by providing the file and achievement ID.")
    @ApiResponse(responseCode = "200", description = "Image uploaded successfully", content = @Content(schema = @Schema(implementation = AchievementModel.class), mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Achievement not found")
    public ResponseEntity<Object> uploadImage(
            @Parameter(description = "Image file to upload", required = true) @RequestParam("file") MultipartFile file,
            @Parameter(description = "ID of the achievement to associate with the uploaded image", required = true) @RequestParam("achievement_id") int achievementId) {
        Optional<AchievementModel> optionalAchievementModel = achievementServiceImpl.getAchievementById(achievementId);
        if (optionalAchievementModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Achievement with id " + achievementId + " not found");
        } else {
            AchievementModel achievementModel = optionalAchievementModel.orElse(null);
            achievementModel.setAchievementImageUrl(storageServiceClient.uploadFile(file, storageDirectory).getFile_uri());
            achievementServiceImpl.updateAchievement(achievementModel);
            return ResponseEntity.ok().body(achievementModel);
        }
    }

    @DeleteMapping("/delete-image")
    @Operation(summary = "Delete an image associated with an achievement", description = "Delete the image associated with an achievement by providing the image URI and achievement details.")
    @ApiResponse(responseCode = "200", description = "Image deleted successfully")
    @ApiResponse(responseCode = "404", description = "Achievement not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Object> deleteImage(@Parameter(description = "Request body containing achievement ID and image URI", required = true)
                                              @RequestBody AchievementDeleteRequest achievementDeleteRequest) {
        Optional<AchievementModel> optionalAchievementModel = achievementServiceImpl.getAchievementById(achievementDeleteRequest.getAchievement_id());
        if (optionalAchievementModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Achievement with id " + achievementDeleteRequest.getAchievement_id() + " not found");
        }
        AchievementModel achievementModel = optionalAchievementModel.orElse(null);
        achievementModel.setAchievementImageUrl("DEFAULT");
        achievementServiceImpl.updateAchievement(achievementModel);
        try {
            storageServiceClient.deleteFile(new DeleteStorageRequest(achievementDeleteRequest.getFile_uri(), storageDirectory));
            return ResponseEntity.ok().build();
        } catch (FeignException.InternalServerError e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DeleteResponse("the image does not exist or the data was transferred incorrectly"));
        }
    }
}

package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.CharacterActivityProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterActivityProgressResponseDTO;
import com.pm.loaplanner.service.CharacterActivityProgressService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterActivityProgressController {
    private final CharacterActivityProgressService characterActivityProgressService;

    public CharacterActivityProgressController(CharacterActivityProgressService characterActivityProgressService) {
        this.characterActivityProgressService = characterActivityProgressService;
    }

    @Operation(summary = "Create a new Character Activity Progress")
    @PostMapping("/api/activity/progress")
    public ResponseEntity<CharacterActivityProgressResponseDTO> createActivityProgress(@RequestBody CharacterActivityProgressRequestDTO requestDTO) {
        CharacterActivityProgressResponseDTO createdActivityProgress = characterActivityProgressService.createActivityProgress(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdActivityProgress);
    }
}

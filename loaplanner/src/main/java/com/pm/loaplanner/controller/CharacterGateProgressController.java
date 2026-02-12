package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressResponseDTO;
import com.pm.loaplanner.service.CharacterGateProgressService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterGateProgressController {
    private final CharacterGateProgressService characterGateProgressService;

    public CharacterGateProgressController(CharacterGateProgressService characterGateProgressService) {
        this.characterGateProgressService = characterGateProgressService;
    }

    @Operation(summary = "Create a new Character Gate Progress")
    @PostMapping("/api/progress")
    public ResponseEntity<CharacterGateProgressResponseDTO> createProgress(@RequestBody CharacterGateProgressRequestDTO requestDTO) {
        CharacterGateProgressResponseDTO createdProgress = characterGateProgressService.createCharacterGateProgress(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProgress);
    }
}

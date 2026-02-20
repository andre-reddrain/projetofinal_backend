package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressResponseDTO;
import com.pm.loaplanner.service.CharacterGateProgressService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/gate-progress")
public class CharacterGateProgressController {
    private final CharacterGateProgressService characterGateProgressService;

    public CharacterGateProgressController(CharacterGateProgressService characterGateProgressService) {
        this.characterGateProgressService = characterGateProgressService;
    }

    @GetMapping
    @Operation(summary = "Get all the Character Gate Progress of multiple Characters.")
    public ResponseEntity<List<CharacterGateProgressResponseDTO>> getCharacterGateProgressByCharactersIds(@RequestParam List<UUID> characterIds) {
        List<CharacterGateProgressResponseDTO> characterGateProgress = characterGateProgressService.getCharacterGateProgressByCharactersIds(characterIds);
        return ResponseEntity.ok().body(characterGateProgress);
    }

    @PostMapping
    @Operation(summary = "Create a new Character Gate Progress")
    public ResponseEntity<CharacterGateProgressResponseDTO> createProgress(@RequestBody CharacterGateProgressRequestDTO requestDTO) {
        CharacterGateProgressResponseDTO createdProgress = characterGateProgressService.createCharacterGateProgress(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProgress);
    }

    @PutMapping("/bulk")
    @Operation(summary = "Bulk upsert of Character Gate Progress")
    public ResponseEntity<List<CharacterGateProgressResponseDTO>> bulkUpsertProgress(@RequestBody List<CharacterGateProgressRequestDTO> requestDTOs) {
        List<CharacterGateProgressResponseDTO> result = characterGateProgressService.bulkUpsertProgress(requestDTOs);

        return ResponseEntity.ok().body(result);
    }
}

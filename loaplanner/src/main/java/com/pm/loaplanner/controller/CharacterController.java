package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.CharacterRequestDTO;
import com.pm.loaplanner.dto.CharacterResponseDTO;
import com.pm.loaplanner.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(summary = "Create a new Character")
    @PostMapping("/api/character")
    public ResponseEntity<CharacterResponseDTO> createCharacter(@RequestBody CharacterRequestDTO characterRequestDTO) {
        CharacterResponseDTO createdChar = characterService.createCharacter(characterRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdChar);
    }
}

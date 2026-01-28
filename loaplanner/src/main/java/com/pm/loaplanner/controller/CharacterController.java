package com.pm.loaplanner.controller;

import com.pm.loaplanner.config.CustomUserDetails;
import com.pm.loaplanner.dto.CharacterRequestDTO;
import com.pm.loaplanner.dto.CharacterResponseDTO;
import com.pm.loaplanner.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(summary = "Create a new Character")
    @PostMapping("/api/character")
    public ResponseEntity<Void> createCharacter(@RequestBody CharacterRequestDTO characterRequestDTO) {
        characterService.createCharacter(characterRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all characters from a user")
    @GetMapping("/api/characters")
    public ResponseEntity<List<CharacterResponseDTO>> getCharactersOfUser(@AuthenticationPrincipal CustomUserDetails user) {
        List<CharacterResponseDTO> characters = characterService.getCharactersOfUser(user.getId());
        return ResponseEntity.ok().body(characters);
    }
}

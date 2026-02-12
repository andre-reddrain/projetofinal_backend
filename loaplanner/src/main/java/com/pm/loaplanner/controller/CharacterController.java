package com.pm.loaplanner.controller;

import com.pm.loaplanner.config.CustomUserDetails;
import com.pm.loaplanner.dto.Character.CharacterRequestDTO;
import com.pm.loaplanner.dto.Character.CharacterResponseDTO;
import com.pm.loaplanner.dto.Character.CharacterUpdateRequestDTO;
import com.pm.loaplanner.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(summary = "Create a new Character")
    @PostMapping("/api/character")
    public ResponseEntity<CharacterResponseDTO> createCharacter(
            @AuthenticationPrincipal CustomUserDetails user,
            @RequestBody CharacterRequestDTO characterRequestDTO) {
        CharacterResponseDTO newChar = characterService.createCharacter(user.getId(), characterRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newChar);
    }

    @Operation(summary = "Get all characters from a user")
    @GetMapping("/api/characters")
    public ResponseEntity<List<CharacterResponseDTO>> getCharactersOfUser(@AuthenticationPrincipal CustomUserDetails user) {
        List<CharacterResponseDTO> characters = characterService.getCharactersOfUser(user.getId());
        return ResponseEntity.ok().body(characters);
    }

    @Operation(summary = "Updates a character")
    @PutMapping("/api/character/{id}")
    public ResponseEntity<CharacterResponseDTO> updateCharacter(@PathVariable UUID id, @RequestBody CharacterUpdateRequestDTO characterRequestDTO) {
        CharacterResponseDTO updatedCharacter = characterService.updateCharacter(id, characterRequestDTO);
        return ResponseEntity.ok().body(updatedCharacter);
    }

    @Operation(summary = "Deletes a character")
    @DeleteMapping("/api/character/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable UUID id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }
}

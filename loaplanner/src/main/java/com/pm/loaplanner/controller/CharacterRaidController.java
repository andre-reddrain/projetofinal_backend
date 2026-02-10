package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidRequestDTO;
import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidResponseDTO;
import com.pm.loaplanner.service.CharacterRaidService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CharacterRaidController {
    private final CharacterRaidService characterRaidService;

    public CharacterRaidController(CharacterRaidService characterRaidService) {
        this.characterRaidService = characterRaidService;
    }

    @Operation(summary = "Get all the Character Raids of a Character.")
    @GetMapping("/api/character-raids")
    public ResponseEntity<List<CharacterRaidResponseDTO>> getCharacterRaidsByCharacterIds(@RequestParam List<UUID> characterIds) {
        List<CharacterRaidResponseDTO> characterRaids = characterRaidService.getCharacterRaidsByCharacterIds(characterIds);
        return ResponseEntity.ok().body(characterRaids);
    }
}

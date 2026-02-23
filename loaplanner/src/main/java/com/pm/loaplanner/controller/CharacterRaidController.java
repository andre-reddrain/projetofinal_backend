package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidResponseDTO;
import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidUpdateRequestDTO;
import com.pm.loaplanner.service.CharacterRaidService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/character-raids")
public class CharacterRaidController {
    private final CharacterRaidService characterRaidService;

    public CharacterRaidController(CharacterRaidService characterRaidService) {
        this.characterRaidService = characterRaidService;
    }

    @GetMapping
    @Operation(summary = "Get all the Character Raids of multiple Characters.")
    public ResponseEntity<List<CharacterRaidResponseDTO>> getCharacterRaidsByCharacterIds(@RequestParam List<UUID> characterIds) {
        List<CharacterRaidResponseDTO> characterRaids = characterRaidService.getCharacterRaidsByCharacterIds(characterIds);
        return ResponseEntity.ok().body(characterRaids);
    }

    @PutMapping("/bulk")
    @Operation(summary = "Updates multiple Character Raids (bulk update).")
    public ResponseEntity<Void> bulkUpdate(@RequestBody List<CharacterRaidUpdateRequestDTO> charRaidDTOs) {
        characterRaidService.bulkUpdateCharacterRaids(charRaidDTOs);
        return ResponseEntity.ok().build();
    }
}

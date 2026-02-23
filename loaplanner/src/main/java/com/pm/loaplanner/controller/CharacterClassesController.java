package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.Character.CharacterClassesDTO;
import com.pm.loaplanner.service.CharacterClassesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/character-classes")
public class CharacterClassesController {
    private final CharacterClassesService characterClassesService;

    public  CharacterClassesController(CharacterClassesService characterClassesService) {
        this.characterClassesService = characterClassesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CharacterClassesDTO>> getAllCharacterClasses() {
        List<CharacterClassesDTO> characterClasses = characterClassesService.getAllCharacterClasses();
        return ResponseEntity.ok().body(characterClasses);
    }
}

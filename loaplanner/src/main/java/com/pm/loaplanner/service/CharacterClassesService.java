package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.Character.CharacterClassesDTO;
import com.pm.loaplanner.mapper.CharacterClassesMapper;
import com.pm.loaplanner.model.CharacterClasses;
import com.pm.loaplanner.repository.CharacterClassesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterClassesService {
    private CharacterClassesRepository characterClassesRepository;

    public CharacterClassesService(CharacterClassesRepository repository) {
        this.characterClassesRepository = repository;
    }

    @Transactional
    public List<CharacterClassesDTO> getAllCharacterClasses() {
        List<CharacterClasses> characterClasses = this.characterClassesRepository.findAll();
        List<CharacterClassesDTO> dtos =
                characterClasses.stream().map(CharacterClassesMapper::toDTO).toList();

        return dtos;
    }
}

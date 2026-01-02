package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.CharacterRequestDTO;
import com.pm.loaplanner.dto.CharacterResponseDTO;
import com.pm.loaplanner.exception.ApiException;
import com.pm.loaplanner.mapper.CharacterMapper;
import com.pm.loaplanner.model.Character;
import com.pm.loaplanner.model.CharacterClasses;
import com.pm.loaplanner.model.User;
import com.pm.loaplanner.repository.CharacterClassesRepository;
import com.pm.loaplanner.repository.CharacterRepository;
import com.pm.loaplanner.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final UserRepository userRepository;
    private final CharacterClassesRepository characterClassesRepository;

    public CharacterService(
            CharacterRepository characterRepository,
            UserRepository userRepository,
            CharacterClassesRepository characterClassesRepository) {
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
        this.characterClassesRepository = characterClassesRepository;
    }

    public CharacterResponseDTO createCharacter(CharacterRequestDTO characterRequestDTO) {
        try {
            Character newCharacter = CharacterMapper.toModel(characterRequestDTO);

            // Link Foreign Key UserId
            User user = userRepository.findById(characterRequestDTO.getUserId()).get();
            newCharacter.setUser(user);

            // Link Foreign Key ClassId
            CharacterClasses charClass = characterClassesRepository.findById(characterRequestDTO.getClassId()).get();
            newCharacter.setCharClass(charClass);

            // Default values
            newCharacter.setChaosRestCounter(0);
            newCharacter.setGuardianRestCounter(0);

            Character savedCharacter = characterRepository.save(newCharacter);
            return CharacterMapper.toDTO(savedCharacter);
        } catch (DataIntegrityViolationException dataException) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Null fields are not allowed");
        }
    }
}

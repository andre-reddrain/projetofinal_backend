package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.CharacterRequestDTO;
import com.pm.loaplanner.dto.CharacterResponseDTO;
import com.pm.loaplanner.dto.CharacterUpdateRequestDTO;
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

import java.util.List;
import java.util.UUID;

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

    public CharacterResponseDTO createCharacter(UUID userId, CharacterRequestDTO characterRequestDTO) {
        try {
            Character newCharacter = CharacterMapper.toModel(characterRequestDTO);

            // Link Foreign Key UserId
            User user = userRepository.findById(userId).get();
            newCharacter.setUser(user);

            // Link Foreign Key ClassId
            CharacterClasses charClass = characterClassesRepository.findById(characterRequestDTO.getClassId()).get();
            newCharacter.setCharClass(charClass);

            // Default values
            newCharacter.setChaosRestCounter(0);
            newCharacter.setGuardianRestCounter(0);

            Character createdCharacter = characterRepository.save(newCharacter);
            return CharacterMapper.toDTO(createdCharacter);
        } catch (DataIntegrityViolationException dataException) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Null fields are not allowed");
        }
    }

    public List<CharacterResponseDTO> getCharactersOfUser(UUID userId) {
        List<Character> characters = characterRepository.findByUserId(userId);
        List<CharacterResponseDTO> characterResponseDTOS =
                characters.stream().map(CharacterMapper::toDTO).toList();

        return characterResponseDTOS;
    }

    public CharacterResponseDTO updateCharacter(UUID id, CharacterUpdateRequestDTO requestDTO) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Character not found"));

        character.setName(requestDTO.getName());
        character.setDescription(requestDTO.getDescription());
        character.setIlvl(requestDTO.getIlvl());
        character.setChaosRestCounter(requestDTO.getChaosRestCounter());
        character.setGuardianRestCounter(requestDTO.getGuardianRestCounter());

        // Link FKs
        CharacterClasses charClass = characterClassesRepository.findById(requestDTO.getClassId()).get();
        character.setCharClass(charClass);

        Character updatedCharacter = characterRepository.save(character);
        return CharacterMapper.toDTO(updatedCharacter);
    }

    public void deleteCharacter(UUID id) {
        characterRepository.deleteById(id);
    }
}

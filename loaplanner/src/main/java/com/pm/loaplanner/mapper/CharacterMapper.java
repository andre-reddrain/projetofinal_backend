package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.CharacterRequestDTO;
import com.pm.loaplanner.dto.CharacterResponseDTO;
import com.pm.loaplanner.model.Character;

public class CharacterMapper {
    public static CharacterResponseDTO toDTO(Character charac) {
        CharacterResponseDTO charDTO = new CharacterResponseDTO();
        charDTO.setId(charac.getId().toString());
        charDTO.setName(charac.getName());
        return charDTO;
    }

    public static Character toModel(CharacterRequestDTO charDTO) {
        Character character = new Character();
        character.setName(charDTO.getName());
        character.setDescription(charDTO.getDescription());
        character.setIlvl(charDTO.getIlvl());
        character.setChaosRestCounter(charDTO.getChaosRestCounter());
        character.setGuardianRestCounter(charDTO.getGuardianRestCounter());

        return character;
    }
}

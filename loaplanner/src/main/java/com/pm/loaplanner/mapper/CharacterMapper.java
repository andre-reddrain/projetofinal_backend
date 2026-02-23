package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.Character.CharacterRequestDTO;
import com.pm.loaplanner.dto.Character.CharacterResponseDTO;
import com.pm.loaplanner.model.Character;

public class CharacterMapper {
    public static CharacterResponseDTO toDTO(Character charac) {
        CharacterResponseDTO charDTO = new CharacterResponseDTO();
        charDTO.setId(charac.getId().toString());
        charDTO.setName(charac.getName());
        charDTO.setDescription(charac.getDescription());
        charDTO.setIlvl(charac.getIlvl());
        charDTO.setChaosRestCounter(charac.getChaosRestCounter());
        charDTO.setGuardianRestCounter(charac.getGuardianRestCounter());
        charDTO.setCharacterClassId(charac.getCharClass().getId().toString());
        charDTO.setCharacterClassIcon(charac.getCharClass().getIcon());
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

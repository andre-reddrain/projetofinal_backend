package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.Character.CharacterClassesDTO;
import com.pm.loaplanner.model.CharacterClasses;

public class CharacterClassesMapper {
    public static CharacterClassesDTO toDTO(CharacterClasses characterClasses) {
        CharacterClassesDTO dto = new CharacterClassesDTO();
        dto.setId(characterClasses.getId().toString());
        dto.setType(characterClasses.getType());
        dto.setSubtype(characterClasses.getSubtype());
        dto.setIcon(characterClasses.getIcon());
        return dto;
    }
}

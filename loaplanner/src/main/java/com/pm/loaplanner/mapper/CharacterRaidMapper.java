package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidRequestDTO;
import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidResponseDTO;
import com.pm.loaplanner.model.CharacterRaid;

public class CharacterRaidMapper {
    public static CharacterRaidResponseDTO toDTO(CharacterRaid characterRaid) {
        CharacterRaidResponseDTO dto = new CharacterRaidResponseDTO();
        dto.setId(characterRaid.getId().toString());
        dto.setRaidName(characterRaid.getRaid().getName());
        dto.setTracked(characterRaid.isTracked());
        return dto;
    }

    public static CharacterRaid toModel(CharacterRaidRequestDTO dto) {
        CharacterRaid entity = new CharacterRaid();
        entity.setTracked(dto.getIsTracked());
        return entity;
    }
}

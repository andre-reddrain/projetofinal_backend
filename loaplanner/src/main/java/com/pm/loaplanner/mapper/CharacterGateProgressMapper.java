package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.CharacterGateProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterGateProgressResponseDTO;
import com.pm.loaplanner.model.CharacterGateProgress;

public class CharacterGateProgressMapper {
    public static CharacterGateProgressResponseDTO toDTO(CharacterGateProgress characterGateProgress) {
        CharacterGateProgressResponseDTO dto = new CharacterGateProgressResponseDTO();
        dto.setId(characterGateProgress.getId().toString());
        dto.setIsCompleted(characterGateProgress.getIsCompleted());
        dto.setBuyExtraLoot(characterGateProgress.getBuyExtraLoot());
        dto.setGateName(characterGateProgress.getGateDetails().getGate().getName());
        return dto;
    }

    public static CharacterGateProgress toModel(CharacterGateProgressRequestDTO dto) {
        CharacterGateProgress characterGateProgress = new CharacterGateProgress();
        characterGateProgress.setIsCompleted(dto.getIsCompleted());
        characterGateProgress.setBuyExtraLoot(dto.getBuyExtraLoot());
        return characterGateProgress;
    }
}

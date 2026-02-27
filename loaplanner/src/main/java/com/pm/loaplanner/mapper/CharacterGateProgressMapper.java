package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressResponseDTO;
import com.pm.loaplanner.model.CharacterGateProgress;

public class CharacterGateProgressMapper {
    public static CharacterGateProgressResponseDTO toDTO(CharacterGateProgress characterGateProgress) {
        CharacterGateProgressResponseDTO dto = new CharacterGateProgressResponseDTO();
        dto.setId(characterGateProgress.getId().toString());
        dto.setCharacterId(characterGateProgress.getCharacter().getId().toString());
        dto.setGateDetailsId(characterGateProgress.getGateDetails().getId().toString());
        dto.setGateId(characterGateProgress.getGateDetails().getGate().getId().toString());
        dto.setRaidId(characterGateProgress.getGateDetails().getGate().getRaid().getId().toString());
        dto.setIsCompleted(characterGateProgress.getIsCompleted());
        dto.setTakingGold(characterGateProgress.getTakingGold());
        dto.setBuyExtraLoot(characterGateProgress.getBuyExtraLoot());
        dto.setSelected(characterGateProgress.getSelected());
        dto.setGateName(characterGateProgress.getGateDetails().getGate().getName());
        return dto;
    }

    public static CharacterGateProgress toModel(CharacterGateProgressRequestDTO dto) {
        CharacterGateProgress characterGateProgress = new CharacterGateProgress();
        characterGateProgress.setIsCompleted(dto.getIsCompleted());
        characterGateProgress.setTakingGold(dto.getTakingGold());
        characterGateProgress.setBuyExtraLoot(dto.getBuyExtraLoot());
        characterGateProgress.setSelected(dto.getSelected());
        return characterGateProgress;
    }
}

package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.CharacterActivityProgress.CharacterActivityProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterActivityProgress.CharacterActivityProgressResponseDTO;
import com.pm.loaplanner.model.CharacterActivityProgress;

public class CharacterActivityProgressMapper {
    /**
     * Converts the model to a ResponseDTO
     * @param activityProgress Model
     * @return Response DTO
     */
    public static CharacterActivityProgressResponseDTO toDTO(CharacterActivityProgress activityProgress) {
        CharacterActivityProgressResponseDTO dto = new CharacterActivityProgressResponseDTO();
        dto.setId(activityProgress.getId().toString());
        dto.setEntryCounter(activityProgress.getEntryCounter());
        dto.setActivityName(activityProgress.getActivity().getName());
        dto.setActivityType(activityProgress.getActivity().getType().toString());
        return dto;
    }

    /**
     * Converts a RequestDTO to a model
     * @param dto Request DTO
     * @return Model
     */
    public static CharacterActivityProgress toModel(CharacterActivityProgressRequestDTO dto) {
        CharacterActivityProgress activityProgress = new CharacterActivityProgress();
        return activityProgress;
    }
}

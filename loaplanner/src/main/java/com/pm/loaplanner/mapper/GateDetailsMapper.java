package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.GateDetailsResponseDTO;
import com.pm.loaplanner.model.GateDetails;

public class GateDetailsMapper {
    /**
     * Converts the model to a ResponseDTO
     * @param gateDetails Model
     * @return ResponseDTO
     */
    public static GateDetailsResponseDTO toDTO(GateDetails gateDetails) {
        GateDetailsResponseDTO dto = new GateDetailsResponseDTO();
        dto.setId(gateDetails.getId().toString());
        dto.setEntryLvl(gateDetails.getEntryLvl());
        dto.setExtralootCost(gateDetails.getExtralootCost());
        dto.setDifficulty(gateDetails.getDifficulty().toString());
        return dto;
    }
}

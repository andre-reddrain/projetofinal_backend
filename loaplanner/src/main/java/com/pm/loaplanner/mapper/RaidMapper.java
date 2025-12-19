package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.RaidResponseDTO;
import com.pm.loaplanner.model.Raid;

public class RaidMapper {
    public static RaidResponseDTO toDTO(Raid raid) {
        RaidResponseDTO raidDTO = new RaidResponseDTO();
        raidDTO.setId(raid.getId().toString());
        raidDTO.setName(raid.getName());
        raidDTO.setType(raid.getType());
        raidDTO.setIcon(raid.getIcon());
        return raidDTO;
    }
}

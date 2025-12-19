package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.RaidDTO;
import com.pm.loaplanner.model.Raid;

public class RaidMapper {
    public static RaidDTO toDTO(Raid raid) {
        RaidDTO raidDTO = new RaidDTO();
        raidDTO.setId(raid.getId().toString());
        raidDTO.setName(raid.getName());
        raidDTO.setType(raid.getType());
        raidDTO.setIcon(raid.getIcon());
        raidDTO.setGates(raid.getGates().stream()
                .map(GateMapper::toDTO).toList());
        return raidDTO;
    }
}

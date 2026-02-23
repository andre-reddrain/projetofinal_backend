package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.Raid.RaidDTO;
import com.pm.loaplanner.dto.Raid.RaidWithGatesDTO;
import com.pm.loaplanner.model.Raid;

public class RaidMapper {
    public static RaidWithGatesDTO toGatesDTO(Raid raid) {
        RaidWithGatesDTO raidDTO = new RaidWithGatesDTO();
        raidDTO.setId(raid.getId().toString());
        raidDTO.setName(raid.getName());
        raidDTO.setType(raid.getType());
        raidDTO.setIcon(raid.getIcon());
        raidDTO.setGates(raid.getGates().stream()
                .map(GateMapper::toDTO).toList());
        return raidDTO;
    }

    public static RaidDTO toDTO(Raid raid) {
        RaidDTO raidDTO = new RaidDTO();
        raidDTO.setId(raid.getId().toString());
        raidDTO.setName(raid.getName());
        raidDTO.setType(raid.getType());
        raidDTO.setIcon(raid.getIcon());
        return raidDTO;
    }


}

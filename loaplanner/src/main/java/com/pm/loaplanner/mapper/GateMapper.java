package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.Gate.GateDTO;
import com.pm.loaplanner.model.Gate;

public class GateMapper {
    public static GateDTO toDTO(Gate gate) {
        GateDTO gateDTO = new GateDTO();
        gateDTO.setId(gate.getId().toString());
        gateDTO.setName(gate.getName());
        gateDTO.setNumber(gate.getNumber());
        return gateDTO;
    }
}

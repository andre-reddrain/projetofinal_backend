package com.pm.loaplanner.dto.Raid;

import com.pm.loaplanner.dto.Gate.GateGoldPlannerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class RaidGoldPlannerDTO {
    private UUID id;
    private String name;
    private String type;
    private List<GateGoldPlannerDTO> gates;
}

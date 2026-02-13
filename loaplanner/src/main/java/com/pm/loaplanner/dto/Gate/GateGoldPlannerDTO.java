package com.pm.loaplanner.dto.Gate;

import com.pm.loaplanner.dto.GateDetails.GateDetailsGoldPlannerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class GateGoldPlannerDTO {
    private UUID id;
    private String name;
    private int number;
    private boolean isLocked;
    private List<GateDetailsGoldPlannerDTO> details;
}

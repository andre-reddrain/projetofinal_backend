package com.pm.loaplanner.dto.GoldPlanner;

import com.pm.loaplanner.dto.Raid.RaidGoldPlannerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GoldPlannerResponseDTO {
    List<RaidGoldPlannerDTO> raids;
}

package com.pm.loaplanner.dto.GateDetails;

import com.pm.loaplanner.dto.Rewards.RewardGoldPlannerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class GateDetailsGoldPlannerDTO {
    private UUID id;
    private int entryLvl;
    private int extralootCost;
    private String difficulty;
    private List<RewardGoldPlannerDTO> rewards;
}

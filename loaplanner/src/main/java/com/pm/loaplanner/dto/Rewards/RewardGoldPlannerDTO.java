package com.pm.loaplanner.dto.Rewards;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RewardGoldPlannerDTO {
    private String id;
    private String type;
    private int amount;
    private String icon;
    private boolean isExtraReward;
}

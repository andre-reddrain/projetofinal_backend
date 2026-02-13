package com.pm.loaplanner.dto.Rewards;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RewardRequestDTO {
    @NotNull(message = "Amount is required")
    private int amount;

    private Boolean isExtraReward;

    // FKs
    @NotBlank(message = "Gate Details is required")
    private UUID gateDetailsId;

    @NotBlank(message = "Type Reward is required")
    private UUID typeRewardId;
}

package com.pm.loaplanner.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RewardRequestDTO {
    @NotNull(message = "Ammount is required")
    private int ammount;

    private Boolean isExtraReward;

    // FKs
    @NotBlank(message = "Gate Details is required")
    private UUID gateDetailsId;

    @NotBlank(message = "Type Reward is required")
    private UUID typeRewardId;
}

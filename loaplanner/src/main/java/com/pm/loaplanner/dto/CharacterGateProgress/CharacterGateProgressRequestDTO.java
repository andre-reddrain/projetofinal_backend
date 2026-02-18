package com.pm.loaplanner.dto.CharacterGateProgress;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CharacterGateProgressRequestDTO {
    private Boolean isCompleted;

    private Boolean takingGold;

    private Boolean buyExtraLoot;

    // FKs
    @NotNull(message = "Character is required")
    private UUID characterId;

    @NotNull(message = "Gate Details is required")
    private UUID gateDetailId;
}

package com.pm.loaplanner.dto.CharacterGateProgress;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CharacterGateProgressGoldPlannerDTO {
    private UUID id;
    private Boolean isCompleted;
    private Boolean buyExtraLoot;
}

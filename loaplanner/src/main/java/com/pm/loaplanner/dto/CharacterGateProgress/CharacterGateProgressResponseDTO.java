package com.pm.loaplanner.dto.CharacterGateProgress;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterGateProgressResponseDTO {
    private String id;
    private String characterId;
    private String gateDetailsId;
    private String gateId;
    private String raidId;
    private Boolean isCompleted;
    private Boolean takingGold;
    private Boolean buyExtraLoot;
    private Boolean selected;
    private String gateName;
}

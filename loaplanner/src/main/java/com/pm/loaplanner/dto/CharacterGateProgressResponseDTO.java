package com.pm.loaplanner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterGateProgressResponseDTO {
    private String id;
    private Boolean isCompleted;
    private Boolean buyExtraLoot;
    private String gateName;
}

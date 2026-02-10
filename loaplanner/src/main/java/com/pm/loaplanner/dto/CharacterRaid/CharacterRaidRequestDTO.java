package com.pm.loaplanner.dto.CharacterRaid;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterRaidRequestDTO {
    @NotNull
    private String characterId;

    @NotNull
    private String raidId;

    @NotNull
    private Boolean isTracked;
}

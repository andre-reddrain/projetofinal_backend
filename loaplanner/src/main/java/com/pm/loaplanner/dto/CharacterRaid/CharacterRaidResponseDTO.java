package com.pm.loaplanner.dto.CharacterRaid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterRaidResponseDTO {
    private String id;
    private String raidName;

    private boolean isTracked;
}

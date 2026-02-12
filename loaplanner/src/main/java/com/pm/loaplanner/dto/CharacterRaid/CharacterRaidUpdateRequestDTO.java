package com.pm.loaplanner.dto.CharacterRaid;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CharacterRaidUpdateRequestDTO {
    private UUID id;
    private boolean tracked;
}

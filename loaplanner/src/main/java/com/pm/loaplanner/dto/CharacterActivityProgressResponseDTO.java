package com.pm.loaplanner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterActivityProgressResponseDTO {
    private String id;
    private int entryCounter;
    private String activityName;
    private String activityType;
}

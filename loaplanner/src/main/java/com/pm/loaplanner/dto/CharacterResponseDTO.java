package com.pm.loaplanner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterResponseDTO {
    private String id;
    private String name;
    private String description;
    private Double ilvl;
    private Integer chaosRestCounter;
    private Integer guardianRestCounter;
}

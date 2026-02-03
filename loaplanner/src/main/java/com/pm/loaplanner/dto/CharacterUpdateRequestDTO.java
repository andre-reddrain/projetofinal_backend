package com.pm.loaplanner.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CharacterUpdateRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    private Double ilvl;

    private Integer chaosRestCounter;

    private Integer guardianRestCounter;

    // FKs
    @NotBlank(message = "Class is required")
    private UUID classId;
}

package com.pm.loaplanner.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CharacterRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "ILVL is required")
    private Double ilvl;

    private Integer chaosRestCounter;

    private Integer guardianRestCounter;

    // FKs
    @NotBlank(message = "User is required")
    private UUID userId;

    @NotBlank(message = "Class is required")
    private UUID classId;
}

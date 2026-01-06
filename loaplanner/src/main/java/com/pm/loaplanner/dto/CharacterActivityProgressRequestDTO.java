package com.pm.loaplanner.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CharacterActivityProgressRequestDTO {
    // FKs
    private UUID characterId;

    @NotNull(message = "Activity is required")
    private UUID activityId;

    private UUID userId;
}

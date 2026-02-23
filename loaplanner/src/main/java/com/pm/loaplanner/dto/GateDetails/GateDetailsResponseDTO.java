package com.pm.loaplanner.dto.GateDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GateDetailsResponseDTO {
    private String id;
    private int entryLvl;
    private int extralootCost;
    private String difficulty;
    private String gateName;
}

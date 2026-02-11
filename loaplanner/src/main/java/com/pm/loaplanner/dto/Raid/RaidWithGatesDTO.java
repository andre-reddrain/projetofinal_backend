package com.pm.loaplanner.dto.Raid;

import com.pm.loaplanner.dto.GateDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RaidWithGatesDTO {
    private String id;
    private String name;
    private String type;
    private String icon;
    private List<GateDTO> gates;
}

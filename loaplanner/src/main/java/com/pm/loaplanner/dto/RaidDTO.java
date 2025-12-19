package com.pm.loaplanner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RaidDTO {
    private String id;
    private String name;
    private String type;
    private String icon;
    private List<GateDTO> gates;
}

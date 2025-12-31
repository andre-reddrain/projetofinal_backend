package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.RaidDTO;
import com.pm.loaplanner.service.RaidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/raids")
public class RaidController {
    private final RaidService raidService;

    public RaidController(RaidService raidService) {
        this.raidService = raidService;
    }

    @GetMapping
    public ResponseEntity<List<RaidDTO>> getAllRaids() {
        List<RaidDTO> raids = raidService.getAllRaids();
        return ResponseEntity.ok().body(raids);
    }
}

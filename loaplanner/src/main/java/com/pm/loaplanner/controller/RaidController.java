package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.Raid.RaidDTO;
import com.pm.loaplanner.dto.Raid.RaidWithGatesDTO;
import com.pm.loaplanner.service.RaidService;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping("/all")
    @Operation(summary = "Get all raids")
    public ResponseEntity<List<RaidDTO>> getAllRaids() {
        List<RaidDTO> raids = raidService.getAllRaids();
        return ResponseEntity.ok().body(raids);
    }

    @GetMapping("/gates")
    @Operation(summary = "Get all raids with gates")
    public ResponseEntity<List<RaidWithGatesDTO>> getAllRaidsWithGates() {
        List<RaidWithGatesDTO> raids = raidService.getAllRaidsWithGates();
        return ResponseEntity.ok().body(raids);
    }
}

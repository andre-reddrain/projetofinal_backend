package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.GateDetailsResponseDTO;
import com.pm.loaplanner.service.GateDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/gate-details")
public class GateDetailsController {
    private final GateDetailsService gateDetailsService;

    public GateDetailsController(GateDetailsService gateDetailsService) {
        this.gateDetailsService = gateDetailsService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get all Gate Details of a Gate")
    public ResponseEntity<List<GateDetailsResponseDTO>> getGateDetailsByGateId(@PathVariable UUID id) {
        List<GateDetailsResponseDTO> gateDetails = gateDetailsService.getGateDetailsByGateId(id);
        return ResponseEntity.ok().body(gateDetails);
    }
}

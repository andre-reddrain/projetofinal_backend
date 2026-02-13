package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.GoldPlanner.GoldPlannerResponseDTO;
import com.pm.loaplanner.service.GoldPlannerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/gold-planner")
public class GoldPlannerController {
    private final GoldPlannerService goldPlannerService;

    public GoldPlannerController(GoldPlannerService goldPlannerService) {
        this.goldPlannerService = goldPlannerService;
    }

    @GetMapping
    @Operation(summary = "Get all the raids, gates, gate details with the gold rewards.")
    public ResponseEntity<GoldPlannerResponseDTO> getGoldPlanner(@RequestParam UUID characterId) {
        GoldPlannerResponseDTO dto = goldPlannerService.getGoldPlanner(characterId);
        return ResponseEntity.ok(dto);
    }
}

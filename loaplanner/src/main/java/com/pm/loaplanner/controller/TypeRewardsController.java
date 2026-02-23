package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.TypeRewards.TypeRewardsDTO;
import com.pm.loaplanner.service.TypeRewardsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/type-rewards")
public class TypeRewardsController {
    private final TypeRewardsService typeRewardsService;

    public TypeRewardsController(TypeRewardsService typeRewardsService) {
        this.typeRewardsService = typeRewardsService;
    }

    @GetMapping
    @Operation(summary = "Get all the Type Rewards")
    public ResponseEntity<List<TypeRewardsDTO>> getAllTypeRewards() {
        List<TypeRewardsDTO> typeRewards = typeRewardsService.getAllTypeRewards();
        return ResponseEntity.ok().body(typeRewards);
    }
}

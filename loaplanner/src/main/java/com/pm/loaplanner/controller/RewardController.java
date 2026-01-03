package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.RewardRequestDTO;
import com.pm.loaplanner.dto.RewardResponseDTO;
import com.pm.loaplanner.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @Operation(summary = "Create a new Reward")
    @PostMapping("/api/reward")
    public ResponseEntity<RewardResponseDTO> createReward(@RequestBody RewardRequestDTO rewardRequestDTO) {
        RewardResponseDTO createdReward = rewardService.createReward(rewardRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdReward);
    }
}

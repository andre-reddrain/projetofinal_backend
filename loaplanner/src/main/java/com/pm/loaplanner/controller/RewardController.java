package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.RewardRequestDTO;
import com.pm.loaplanner.dto.RewardResponseDTO;
import com.pm.loaplanner.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/api/rewards")
    @Operation(summary = "Get all Rewards from multiple Gate Details")
    public ResponseEntity<List<RewardResponseDTO>> getRewardsByGateDetailsId(@RequestParam List<UUID> gateDetailsIds) {
        List<RewardResponseDTO> rewards = rewardService.getRewardsFromGateDetails(gateDetailsIds);
        return ResponseEntity.ok().body(rewards);
    }

    @PostMapping("/api/reward")
    @Operation(summary = "Create a new Reward")
    public ResponseEntity<RewardResponseDTO> createReward(@RequestBody RewardRequestDTO rewardRequestDTO) {
        RewardResponseDTO createdReward = rewardService.createReward(rewardRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdReward);
    }
}

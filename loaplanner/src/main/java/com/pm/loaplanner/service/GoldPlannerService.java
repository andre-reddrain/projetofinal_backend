package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.GoldPlanner.GoldPlannerResponseDTO;
import com.pm.loaplanner.mapper.GoldPlannerMapper;
import com.pm.loaplanner.model.GateDetails;
import com.pm.loaplanner.model.Raid;
import com.pm.loaplanner.model.Reward;
import com.pm.loaplanner.repository.RaidRepository;
import com.pm.loaplanner.repository.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GoldPlannerService {
    private final RaidRepository raidRepository;
    private final RewardRepository rewardRepository;

    private static final UUID GOLD_ID = UUID.fromString("ddea93e5-dd37-11f0-a6e8-0a0027000013");
    private static final UUID BOUND_GOLD_ID = UUID.fromString("ddea948e-dd37-11f0-a6e8-0a0027000013");

    public GoldPlannerService(
            RaidRepository raidRepository,
            RewardRepository rewardRepository) {
        this.raidRepository = raidRepository;
        this.rewardRepository = rewardRepository;
    }

    public GoldPlannerResponseDTO getGoldPlanner() {
        List<Raid> raids = raidRepository.findAllRaidsForGoldPlanner();

        List<UUID> detailsIds = raids.stream()
                .flatMap(r -> r.getGates().stream())
                .flatMap(g -> g.getGateDetails().stream())
                .map(GateDetails::getId)
                .toList();

        List<Reward> rewards = rewardRepository.findGoldPlannerRewards(
                detailsIds,
                List.of(GOLD_ID, BOUND_GOLD_ID)
        );

        Map<UUID, List<Reward>> rewardsByDetailsId =
                rewards.stream().collect(Collectors.groupingBy(
                        r -> r.getGateDetails().getId()
                ));

        return GoldPlannerMapper.toGoldPlannerResponse(raids, rewardsByDetailsId);
    }
}

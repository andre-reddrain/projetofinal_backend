package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.GoldPlanner.GoldPlannerResponseDTO;
import com.pm.loaplanner.mapper.GoldPlannerMapper;
import com.pm.loaplanner.model.CharacterGateProgress;
import com.pm.loaplanner.model.GateDetails;
import com.pm.loaplanner.model.Raid;
import com.pm.loaplanner.model.Reward;
import com.pm.loaplanner.repository.CharacterGateProgressRepository;
import com.pm.loaplanner.repository.RaidRepository;
import com.pm.loaplanner.repository.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GoldPlannerService {
    private final RaidRepository raidRepository;
    private final CharacterGateProgressRepository progressRepository;
    private final RewardRepository rewardRepository;

    private static final UUID GOLD_ID = UUID.fromString("ddea93e5-dd37-11f0-a6e8-0a0027000013");
    private static final UUID BOUND_GOLD_ID = UUID.fromString("ddea948e-dd37-11f0-a6e8-0a0027000013");

    public GoldPlannerService(
            RaidRepository raidRepository,
            CharacterGateProgressRepository progressRepository,
            RewardRepository rewardRepository) {
        this.raidRepository = raidRepository;
        this.progressRepository = progressRepository;
        this.rewardRepository = rewardRepository;
    }

    public GoldPlannerResponseDTO getGoldPlanner(UUID characterId) {
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

        List<CharacterGateProgress> progressList = progressRepository.findByCharacterId(characterId);

        Map<UUID, CharacterGateProgress> progressByDetailsId =
                progressList.stream()
                        .collect(Collectors.toMap(
                                p -> p.getGateDetails().getId(),
                                Function.identity()
                        ));

        return GoldPlannerMapper.toGoldPlannerResponse(raids, progressByDetailsId, rewardsByDetailsId);
    }
}

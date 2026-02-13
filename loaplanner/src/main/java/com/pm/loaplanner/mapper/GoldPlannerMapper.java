package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressGoldPlannerDTO;
import com.pm.loaplanner.dto.Gate.GateGoldPlannerDTO;
import com.pm.loaplanner.dto.GateDetails.GateDetailsGoldPlannerDTO;
import com.pm.loaplanner.dto.GoldPlanner.GoldPlannerResponseDTO;
import com.pm.loaplanner.dto.Raid.RaidGoldPlannerDTO;
import com.pm.loaplanner.dto.Rewards.RewardGoldPlannerDTO;
import com.pm.loaplanner.model.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GoldPlannerMapper {
    public static GoldPlannerResponseDTO toGoldPlannerResponse(
            List<Raid> raids,
            Map<UUID, CharacterGateProgress> progressMap,
            Map<UUID, List<Reward>> rewardsMap
    ) {
        return new GoldPlannerResponseDTO(
                raids.stream()
                        .map(r -> toRaidDTO(r, progressMap, rewardsMap))
                        .toList()
        );
    }

    private static RaidGoldPlannerDTO toRaidDTO(
            Raid raid,
            Map<UUID, CharacterGateProgress> progressMap,
            Map<UUID, List<Reward>> rewardsMap
    ){
        return new RaidGoldPlannerDTO(
                raid.getId(),
                raid.getName(),
                raid.getType(),
                raid.getGates().stream()
                        .map(g -> toGateDTO(g, progressMap, rewardsMap))
                        .toList()
        );
    }

    private static GateGoldPlannerDTO toGateDTO(
            Gate gate,
            Map<UUID, CharacterGateProgress> progressMap,
            Map<UUID, List<Reward>> rewardsMap
    ) {
        return new GateGoldPlannerDTO(
                gate.getId(),
                gate.getName(),
                gate.getNumber(),
                false,
                gate.getGateDetails().stream()
                        .map(d -> toGateDetailsDTO(d, progressMap, rewardsMap))
                        .toList()
        );
    }

    private static GateDetailsGoldPlannerDTO toGateDetailsDTO(
            GateDetails details,
            Map<UUID, CharacterGateProgress> progressMap,
            Map<UUID, List<Reward>> rewardsMap
    ) {
        CharacterGateProgress progress = progressMap.get(details.getId());

        List<Reward> rewards =
                rewardsMap.getOrDefault(details.getId(), List.of());

        return new GateDetailsGoldPlannerDTO(
                details.getId(),
                details.getEntryLvl(),
                details.getExtralootCost(),
                details.getDifficulty().name(),
                rewards.stream()
                        .map(GoldPlannerMapper::toRewardDTO)
                        .toList(),
                toProgressDTO(progress)
        );
    }

    private static RewardGoldPlannerDTO toRewardDTO(Reward reward) {
        return new RewardGoldPlannerDTO(
                reward.getId().toString(),
                reward.getTypeRewards().getName(),
                reward.getAmount()
        );
    }

    private static CharacterGateProgressGoldPlannerDTO toProgressDTO(
            CharacterGateProgress progress
    ) {
        if (progress == null) {
            return null;
        }

        return new CharacterGateProgressGoldPlannerDTO(
                progress.getId(),
                progress.getIsCompleted(),
                progress.getBuyExtraLoot()
        );
    }
}

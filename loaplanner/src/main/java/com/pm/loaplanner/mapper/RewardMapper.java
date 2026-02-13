package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.Rewards.RewardRequestDTO;
import com.pm.loaplanner.dto.Rewards.RewardResponseDTO;
import com.pm.loaplanner.model.Reward;

public class RewardMapper {
    public static RewardResponseDTO toFullDTO(Reward reward) {
        RewardResponseDTO dto = new RewardResponseDTO();
        dto.setId(reward.getId().toString());
        dto.setIsExtraReward(reward.getIsExtraReward());
        dto.setAmount(reward.getAmount());
        dto.setTypeRewardId(reward.getTypeRewards().getId().toString());
        dto.setGateDetailsId(reward.getGateDetails().getId().toString());
        return dto;
    }

    public static RewardResponseDTO toGateDetailsDTO(Reward reward) {
        RewardResponseDTO dto = new RewardResponseDTO();
        dto.setId(reward.getId().toString());
        dto.setIsExtraReward(reward.getIsExtraReward());
        dto.setAmount(reward.getAmount());
        dto.setTypeRewardId(reward.getTypeRewards().getId().toString());
        return dto;
    }

    public static Reward toModel(RewardRequestDTO rewardDTO) {
        Reward reward = new Reward();
        reward.setAmount(rewardDTO.getAmount());
        reward.setIsExtraReward(rewardDTO.getIsExtraReward());

        return reward;
    }
}

package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.RewardRequestDTO;
import com.pm.loaplanner.dto.RewardResponseDTO;
import com.pm.loaplanner.model.Reward;

public class RewardMapper {
    public static RewardResponseDTO toFullDTO(Reward reward) {
        RewardResponseDTO dto = new RewardResponseDTO();
        dto.setId(reward.getId().toString());
        dto.setIsExtraReward(reward.getIsExtraReward());
        dto.setAmmount(reward.getAmmount());
        dto.setTypeRewardId(reward.getTypeRewards().getId().toString());
        dto.setGateDetailsId(reward.getGateDetails().getId().toString());
        return dto;
    }

    public static RewardResponseDTO toGateDetailsDTO(Reward reward) {
        RewardResponseDTO dto = new RewardResponseDTO();
        dto.setId(reward.getId().toString());
        dto.setIsExtraReward(reward.getIsExtraReward());
        dto.setAmmount(reward.getAmmount());
        dto.setTypeRewardId(reward.getTypeRewards().getId().toString());
        return dto;
    }

    public static Reward toModel(RewardRequestDTO rewardDTO) {
        Reward reward = new Reward();
        reward.setAmmount(rewardDTO.getAmmount());
        reward.setIsExtraReward(rewardDTO.getIsExtraReward());

        return reward;
    }
}

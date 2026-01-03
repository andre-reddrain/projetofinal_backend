package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.RewardRequestDTO;
import com.pm.loaplanner.dto.RewardResponseDTO;
import com.pm.loaplanner.model.Reward;

public class RewardMapper {
    public static RewardResponseDTO toDTO(Reward reward) {
        RewardResponseDTO rewardDTO = new RewardResponseDTO();
        rewardDTO.setId(reward.getId().toString());
        rewardDTO.setIsExtraReward(reward.getIsExtraReward());
        rewardDTO.setTypeRewardName(reward.getTypeRewards().getName());
        return rewardDTO;
    }

    public static Reward toModel(RewardRequestDTO rewardDTO) {
        Reward reward = new Reward();
        reward.setAmmount(rewardDTO.getAmmount());
        reward.setIsExtraReward(rewardDTO.getIsExtraReward());

        return reward;
    }
}

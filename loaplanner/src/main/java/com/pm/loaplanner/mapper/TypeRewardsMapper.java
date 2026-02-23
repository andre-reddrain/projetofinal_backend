package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.TypeRewards.TypeRewardsDTO;
import com.pm.loaplanner.model.TypeRewards;

public class TypeRewardsMapper {
    /**
     * Converts the model to a DTO
     * @param typeRewards Model
     * @return DTO
     */
    public static TypeRewardsDTO toDTO(TypeRewards typeRewards) {
        TypeRewardsDTO dto = new TypeRewardsDTO();
        dto.setId(typeRewards.getId().toString());
        dto.setName(typeRewards.getName());
        dto.setTier(typeRewards.getTier());
        dto.setClassType(typeRewards.getClassType());
        dto.setGrade(typeRewards.getGrade());
        dto.setIcon(typeRewards.getIcon());
        return dto;
    }
}

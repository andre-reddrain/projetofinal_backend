package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.TypeRewardsDTO;
import com.pm.loaplanner.mapper.TypeRewardsMapper;
import com.pm.loaplanner.model.TypeRewards;
import com.pm.loaplanner.repository.TypeRewardsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeRewardsService {
    private final TypeRewardsRepository repository;

    public TypeRewardsService(TypeRewardsRepository repository) {
        this.repository = repository;
    }

    public List<TypeRewardsDTO> getAllTypeRewards() {
        List<TypeRewards> typeRewards = repository.findAll();
        List<TypeRewardsDTO> typeRewardsDTOs =
                typeRewards.stream().map(TypeRewardsMapper::toDTO).toList();

        return typeRewardsDTOs;
    }
}

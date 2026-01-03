package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.RewardRequestDTO;
import com.pm.loaplanner.dto.RewardResponseDTO;
import com.pm.loaplanner.exception.ApiException;
import com.pm.loaplanner.mapper.RewardMapper;
import com.pm.loaplanner.model.GateDetails;
import com.pm.loaplanner.model.Reward;
import com.pm.loaplanner.model.TypeRewards;
import com.pm.loaplanner.repository.GateDetailsRepository;
import com.pm.loaplanner.repository.RewardRepository;
import com.pm.loaplanner.repository.TypeRewardsRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private final RewardRepository rewardRepository;
    private final GateDetailsRepository gateDetailsRepository;
    private final TypeRewardsRepository typeRewardsRepository;

    public RewardService(
            RewardRepository rewardRepository,
            GateDetailsRepository gateDetailsRepository,
            TypeRewardsRepository typeRewardsRepository) {
        this.rewardRepository = rewardRepository;
        this.gateDetailsRepository = gateDetailsRepository;
        this.typeRewardsRepository = typeRewardsRepository;
    }

    public RewardResponseDTO createReward(RewardRequestDTO rewardRequestDTO) {
        try {
            Reward newReward = RewardMapper.toModel(rewardRequestDTO);

            // Link FK GateDetails
            GateDetails gateDetails = gateDetailsRepository.findById(rewardRequestDTO.getGateDetailsId()).get();
            newReward.setGateDetails(gateDetails);

            // Link FK TypeRewards
            TypeRewards typeReward = typeRewardsRepository.findById(rewardRequestDTO.getTypeRewardId()).get();
            newReward.setTypeRewards(typeReward);

            Reward savedReward = rewardRepository.save(newReward);
            return RewardMapper.toDTO(savedReward);
        } catch (DataIntegrityViolationException | InvalidDataAccessApiUsageException ex) {
            System.out.println(ex.getMessage());
            throw new ApiException(HttpStatus.BAD_REQUEST, "Null fields are not allowed");
        }
    }
}

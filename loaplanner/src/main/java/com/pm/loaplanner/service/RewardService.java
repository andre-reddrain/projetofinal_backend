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
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public List<RewardResponseDTO> getRewardsFromGateDetails(List<UUID> gateDetailsIds) {
        List<Reward> rewards = rewardRepository.findByGateDetailsIdIn(gateDetailsIds);
        List<RewardResponseDTO> rewardResponseDTOS =
                rewards.stream().map(RewardMapper::toGateDetailsDTO).toList();

        return rewardResponseDTOS;
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
            return RewardMapper.toFullDTO(savedReward);
        } catch (DataIntegrityViolationException | InvalidDataAccessApiUsageException ex) {
            System.out.println(ex.getMessage());
            throw new ApiException(HttpStatus.BAD_REQUEST, "Null fields are not allowed");
        }
    }

    @Transactional
    public List<RewardResponseDTO> createRewards(List<RewardRequestDTO> rewardDTOs) {
        List<Reward> rewards = new ArrayList<>();

        for (RewardRequestDTO dto : rewardDTOs) {
            Reward newReward = RewardMapper.toModel(dto);

            // Link FK GateDetails
            GateDetails gateDetails = gateDetailsRepository.findById(dto.getGateDetailsId()).get();
            newReward.setGateDetails(gateDetails);

            // Link FK TypeRewards
            TypeRewards typeReward = typeRewardsRepository.findById(dto.getTypeRewardId()).get();
            newReward.setTypeRewards(typeReward);

            rewards.add(newReward);
        }

        List<Reward> savedRewards = rewardRepository.saveAll(rewards);

        return savedRewards.stream().map(RewardMapper::toFullDTO).toList();
    }

    public void deleteReward(UUID id) {
        rewardRepository.deleteById(id);
    }
}

package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.RaidResponseDTO;
import com.pm.loaplanner.mapper.RaidMapper;
import com.pm.loaplanner.model.Raid;
import com.pm.loaplanner.repository.RaidRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaidService {
    private RaidRepository raidRepository;

    public RaidService(RaidRepository raidRepository) {
        this.raidRepository = raidRepository;
    }

    public List<RaidResponseDTO> getAllRaids() {
        List<Raid> raids = raidRepository.findAll();
        List<RaidResponseDTO> raidResponseDTOs =
            raids.stream().map(RaidMapper::toDTO).toList();

        return raidResponseDTOs;
    }
}

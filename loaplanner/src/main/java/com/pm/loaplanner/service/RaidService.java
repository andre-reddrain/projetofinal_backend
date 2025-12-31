package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.RaidDTO;
import com.pm.loaplanner.mapper.RaidMapper;
import com.pm.loaplanner.model.Raid;
import com.pm.loaplanner.repository.RaidRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RaidService {
    private RaidRepository raidRepository;

    public RaidService(RaidRepository raidRepository) {
        this.raidRepository = raidRepository;
    }

    @Transactional(readOnly = true)
    public List<RaidDTO> getAllRaids() {
        List<Raid> raids = raidRepository.findRaidsWithGates();
        List<RaidDTO> raidDTOS =
            raids.stream().map(RaidMapper::toDTO).toList();

        return raidDTOS;
    }
}

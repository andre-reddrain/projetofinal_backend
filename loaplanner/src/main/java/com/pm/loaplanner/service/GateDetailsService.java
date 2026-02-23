package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.GateDetails.GateDetailsResponseDTO;
import com.pm.loaplanner.mapper.GateDetailsMapper;
import com.pm.loaplanner.model.GateDetails;
import com.pm.loaplanner.repository.GateDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GateDetailsService {
    private final GateDetailsRepository repository;

    public GateDetailsService(GateDetailsRepository repository) {
        this.repository = repository;
    }

    public List<GateDetailsResponseDTO> getGateDetailsByGateIds(List<UUID> gateIds) {
        List<GateDetails> gateDetails = repository.findByGateIdIn(gateIds);
        List<GateDetailsResponseDTO> gateDetailsResponseDTOS =
                gateDetails.stream().map(GateDetailsMapper::toDTO).toList();

        return gateDetailsResponseDTOS;
    }

    public List<GateDetailsResponseDTO> getAllGateDetails() {
        List<GateDetails> gateDetails = repository.findAll();
        List<GateDetailsResponseDTO> gateDetailsResponseDTOS =
                gateDetails.stream().map(GateDetailsMapper::toDTO).toList();

        return gateDetailsResponseDTOS;
    }
}

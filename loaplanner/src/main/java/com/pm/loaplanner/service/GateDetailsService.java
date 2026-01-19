package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.GateDetailsResponseDTO;
import com.pm.loaplanner.mapper.GateDetailsMapper;
import com.pm.loaplanner.model.GateDetails;
import com.pm.loaplanner.repository.GateDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GateDetailsService {
    private GateDetailsRepository repository;

    public GateDetailsService(GateDetailsRepository repository) {
        this.repository = repository;
    }

    public List<GateDetailsResponseDTO> getGateDetailsByGateId(UUID id) {
        List<GateDetails> gateDetails = repository.findByGateId(id);
        List<GateDetailsResponseDTO> gateDetailsResponseDTOS =
                gateDetails.stream().map(GateDetailsMapper::toDTO).toList();

        return gateDetailsResponseDTOS;
    }
}

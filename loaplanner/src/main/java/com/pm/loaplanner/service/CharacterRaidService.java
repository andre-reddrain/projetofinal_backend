package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidResponseDTO;
import com.pm.loaplanner.dto.CharacterRaid.CharacterRaidUpdateRequestDTO;
import com.pm.loaplanner.mapper.CharacterRaidMapper;
import com.pm.loaplanner.model.CharacterRaid;
import com.pm.loaplanner.repository.CharacterRaidRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterRaidService {
    private final CharacterRaidRepository repository;

    public CharacterRaidService(CharacterRaidRepository repository) {
        this.repository = repository;
    }

    public List<CharacterRaidResponseDTO> getCharacterRaidsByCharacterIds(List<UUID> characterIds) {
        List<CharacterRaid> characterRaids = repository.findByCharacterIdIn(characterIds);
        List<CharacterRaidResponseDTO> dtos =
                characterRaids.stream().map(CharacterRaidMapper::toDTO).toList();

        return dtos;
    }

    @Transactional
    public void bulkUpdateCharacterRaids(List<CharacterRaidUpdateRequestDTO> dtos) {
        for (CharacterRaidUpdateRequestDTO dto : dtos) {
            repository.findById(dto.getId()).ifPresent(record -> {
                record.setTracked(dto.isTracked());
            });
        }
    }
}

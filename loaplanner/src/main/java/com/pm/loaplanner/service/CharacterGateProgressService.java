package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterGateProgress.CharacterGateProgressResponseDTO;
import com.pm.loaplanner.exception.ApiException;
import com.pm.loaplanner.mapper.CharacterGateProgressMapper;
import com.pm.loaplanner.model.*;
import com.pm.loaplanner.model.Character;
import com.pm.loaplanner.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CharacterGateProgressService {
    private final CharacterGateProgressRepository characterGateProgressRepository;
    private final CharacterRepository characterRepository;
    private final GateDetailsRepository gateDetailsRepository;

    public CharacterGateProgressService(
            CharacterGateProgressRepository characterGateProgressRepository,
            CharacterRepository characterRepository,
            GateDetailsRepository gateDetailsRepository) {
        this.characterGateProgressRepository = characterGateProgressRepository;
        this.characterRepository = characterRepository;
        this.gateDetailsRepository = gateDetailsRepository;
    }

    public List<CharacterGateProgressResponseDTO> getCharacterGateProgressByCharactersIds(List<UUID> characterIds) {
        List<CharacterGateProgress> gateProgress = characterGateProgressRepository.findByCharacterIdIn(characterIds);
        List<CharacterGateProgressResponseDTO> dtos =
                gateProgress.stream().map(CharacterGateProgressMapper::toDTO).toList();

        return dtos;
    }

    public CharacterGateProgressResponseDTO createCharacterGateProgress(CharacterGateProgressRequestDTO dto) {
        try {
            /* The Create / Update / Delete will have a list for each gate that will be created.
             * It will be sent as a bulk request. For this, we will use @Transactional
             * See what it does, but tldr it all the inserts/updates are a Transaction, if 1 fails,
             * none will be added. Figure out what to do when the Frontend is done.
             */
            CharacterGateProgress newCharacterGateProgress = CharacterGateProgressMapper.toModel(dto);

            // Link FK CharacterId
            Character character = characterRepository.findById(dto.getCharacterId()).get();
            newCharacterGateProgress.setCharacter(character);

            // Link FK GateDetailId
            //GateDetails gateDetails = gateDetailsRepository.findById(dto.getGateDetailId()).get();
            GateDetails gateDetails = gateDetailsRepository.findByIdWithGate(dto.getGateDetailsId()).get();
            newCharacterGateProgress.setGateDetails(gateDetails);

            newCharacterGateProgress.setIsCompleted(false);

            CharacterGateProgress savedCharacterGateProgress = characterGateProgressRepository.save(newCharacterGateProgress);
            return CharacterGateProgressMapper.toDTO(savedCharacterGateProgress);
        } catch (DataIntegrityViolationException | InvalidDataAccessApiUsageException ex) {
            System.out.println(ex.getMessage());
            throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid data provided");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @Transactional
    public List<CharacterGateProgressResponseDTO> bulkUpsertProgress(List<CharacterGateProgressRequestDTO> dtos) {
        List<CharacterGateProgress> toSave = new ArrayList<>(dtos.size());

        for (CharacterGateProgressRequestDTO dto : dtos) {

            // Load GateDetails - needs gateId to verify selected
            GateDetails gateDetails = gateDetailsRepository.findById(dto.getGateDetailsId())
                    .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "GateDetails Not found"));

            // If getSelected is true, all the other gateDetails from the same gate will have selected set to false
            if(Boolean.TRUE.equals(dto.getSelected())) {
                UUID gateId = gateDetails.getGate().getId();
                characterGateProgressRepository.clearSelectedExcept(dto.getCharacterId(), gateId, gateDetails.getId());
            }

            CharacterGateProgress entity = characterGateProgressRepository
                    .findByCharacterIdAndGateDetailsId(dto.getCharacterId(), dto.getGateDetailsId())
                    .orElseGet(() -> {
                        CharacterGateProgress created = new CharacterGateProgress();

                        // Link FK Character
                        Character character = characterRepository.findById(dto.getCharacterId())
                                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Character Not Found"));
                        created.setCharacter(character);

                        // Link FK GateDetails
                        created.setGateDetails(gateDetails);

                        return created;
                    });

            // Update other fields
            entity.setTakingGold(dto.getTakingGold());
            entity.setBuyExtraLoot(dto.getBuyExtraLoot());
            entity.setSelected(Boolean.TRUE.equals(dto.getSelected()));

            toSave.add(entity);
        }

        List<CharacterGateProgress> saved = characterGateProgressRepository.saveAll(toSave);

        return saved.stream().map(CharacterGateProgressMapper::toDTO).toList();
    }
}

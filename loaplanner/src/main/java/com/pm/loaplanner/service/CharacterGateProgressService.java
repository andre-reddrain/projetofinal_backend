package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.CharacterGateProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterGateProgressResponseDTO;
import com.pm.loaplanner.exception.ApiException;
import com.pm.loaplanner.mapper.CharacterGateProgressMapper;
import com.pm.loaplanner.model.*;
import com.pm.loaplanner.model.Character;
import com.pm.loaplanner.repository.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
            GateDetails gateDetails = gateDetailsRepository.findByIdWithGate(dto.getGateDetailId()).get();
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
}

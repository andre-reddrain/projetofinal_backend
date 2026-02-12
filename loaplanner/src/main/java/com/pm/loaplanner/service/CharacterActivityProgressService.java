package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.CharacterActivityProgress.CharacterActivityProgressRequestDTO;
import com.pm.loaplanner.dto.CharacterActivityProgress.CharacterActivityProgressResponseDTO;
import com.pm.loaplanner.exception.ApiException;
import com.pm.loaplanner.mapper.CharacterActivityProgressMapper;
import com.pm.loaplanner.model.*;
import com.pm.loaplanner.model.Character;
import com.pm.loaplanner.repository.ActivityRepository;
import com.pm.loaplanner.repository.CharacterActivityProgressRepository;
import com.pm.loaplanner.repository.CharacterRepository;
import com.pm.loaplanner.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CharacterActivityProgressService {
    private final CharacterActivityProgressRepository activityProgressRepo;
    private final CharacterRepository characterRepo;
    private final ActivityRepository activityRepo;
    private final UserRepository userRepo;

    public CharacterActivityProgressService(
            CharacterActivityProgressRepository activityProgressRepo,
            CharacterRepository characterRepo,
            ActivityRepository activityRepo,
            UserRepository userRepo) {
        this.activityProgressRepo = activityProgressRepo;
        this.characterRepo = characterRepo;
        this.activityRepo = activityRepo;
        this.userRepo = userRepo;
    }

    public CharacterActivityProgressResponseDTO createActivityProgress(CharacterActivityProgressRequestDTO dto) {
        try {
            /* Will have the same logic as createCharacterGateProgress on CharacterGateProgressService */
            CharacterActivityProgress newActivityProgress = CharacterActivityProgressMapper.toModel(dto);

            // Link FK ActivityId
            Activity activity = activityRepo.findById(dto.getActivityId()).get();
            newActivityProgress.setActivity(activity);

            // If Activity is Character, there will be a CharacterId.
            // If it's Roster, there will be a UserId instead.
            if (activity.getType() == ActivityType.CHARACTER) {
                // Link FK CharacterId
                Character character = characterRepo.findById(dto.getCharacterId()).get();
                newActivityProgress.setCharacter(character);
                newActivityProgress.setUser(null);
            } else {
                // Link FK UserId
                User user = userRepo.findById(dto.getUserId()).get();
                newActivityProgress.setUser(user);
                newActivityProgress.setCharacter(null);
            }

            // Validation
            if ((newActivityProgress.getCharacter() == null && newActivityProgress.getUser() == null) ||
                (newActivityProgress.getCharacter() != null && newActivityProgress.getUser() != null)) {
                throw new ApiException(HttpStatus.BAD_REQUEST, "There needs to be either a character or a user");
            }

            CharacterActivityProgress savedActivityProgress = activityProgressRepo.save(newActivityProgress);
            return CharacterActivityProgressMapper.toDTO(savedActivityProgress);
        } catch (DataIntegrityViolationException | InvalidDataAccessApiUsageException ex) {
            System.out.println(ex.getMessage());
            throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid data provided");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}

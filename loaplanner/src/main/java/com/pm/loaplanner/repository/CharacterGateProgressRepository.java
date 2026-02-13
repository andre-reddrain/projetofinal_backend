package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.CharacterGateProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterGateProgressRepository extends JpaRepository<CharacterGateProgress, UUID> {
    List<CharacterGateProgress> findByCharacterId(UUID characterId);
}

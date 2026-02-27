package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.CharacterGateProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CharacterGateProgressRepository extends JpaRepository<CharacterGateProgress, UUID> {
    List<CharacterGateProgress> findByCharacterId(UUID characterId);

    List<CharacterGateProgress> findByCharacterIdIn(List<UUID> characterIds);

    Optional<CharacterGateProgress> findByCharacterIdAndGateDetailsId(UUID characterId, UUID gateDetailsId);

    @Modifying
    @Query("""
      UPDATE CharacterGateProgress cgp
      SET cgp.selected = false
      WHERE cgp.character.id = :characterId
        AND cgp.gateDetails.gate.id = :gateId
        AND cgp.gateDetails.id <> :keepGateDetailsId
    """)
    int clearSelectedExcept(UUID characterId, UUID gateId, UUID keepGateDetailsId);

    @Modifying
    @Query("DELETE FROM CharacterGateProgress cgp WHERE cgp.character.id = :characterId")
    void deleteByCharacterId(@Param("characterId") UUID characterId);
}

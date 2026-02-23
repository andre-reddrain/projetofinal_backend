package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.CharacterRaid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRaidRepository extends JpaRepository<CharacterRaid, UUID> {
    List<CharacterRaid> findByCharacterIdIn(List<UUID> characterIds);

    @Modifying
    @Query("DELETE FROM CharacterRaid cr WHERE cr.character.id = :characterId")
    void deleteByCharacterId(@Param("characterId") UUID characterId);
}

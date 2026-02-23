package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.CharacterActivityProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacterActivityProgressRepository extends JpaRepository<CharacterActivityProgress, UUID> {
}

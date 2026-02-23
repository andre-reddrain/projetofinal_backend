package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.CharacterClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacterClassesRepository extends JpaRepository<CharacterClasses, UUID> {
}

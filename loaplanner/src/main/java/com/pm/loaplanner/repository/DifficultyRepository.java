package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DifficultyRepository extends JpaRepository<Difficulty, UUID> {
}

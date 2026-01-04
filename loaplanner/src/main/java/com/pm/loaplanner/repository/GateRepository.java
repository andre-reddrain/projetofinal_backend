package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GateRepository extends JpaRepository<Gate, UUID> {
}

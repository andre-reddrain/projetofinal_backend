package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.GateDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GateDetailsRepository extends JpaRepository<GateDetails, UUID> {
}

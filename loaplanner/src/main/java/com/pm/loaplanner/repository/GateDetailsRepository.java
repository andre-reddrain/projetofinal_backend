package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.GateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GateDetailsRepository extends JpaRepository<GateDetails, UUID> {
    @Query("SELECT gd FROM GateDetails gd JOIN FETCH gd.gate g WHERE gd.id = :id")
    Optional<GateDetails> findByIdWithGate(UUID id);

    List<GateDetails> findByGateId(UUID id);
}

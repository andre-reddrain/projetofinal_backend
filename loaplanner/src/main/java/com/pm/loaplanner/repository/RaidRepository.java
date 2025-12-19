package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.Raid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RaidRepository extends JpaRepository<Raid, UUID> {

    @Query("SELECT DISTINCT r FROM Raid r LEFT JOIN FETCH r.gates")
    List<Raid> findRaidsWithGates();
}

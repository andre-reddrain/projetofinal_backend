package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RewardRepository extends JpaRepository<Reward, UUID> {
    List<Reward> findByGateDetailsIdIn(List<UUID> gateDetailsIds);
}

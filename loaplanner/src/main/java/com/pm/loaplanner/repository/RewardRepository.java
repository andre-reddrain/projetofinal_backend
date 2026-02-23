package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RewardRepository extends JpaRepository<Reward, UUID> {
    List<Reward> findByGateDetailsIdIn(List<UUID> gateDetailsIds);

    @Query("SELECT r FROM Reward r " +
            "WHERE r.gateDetails.id IN :detailsIds " +
            "AND r.typeRewards.id IN :typeRewardIds")
    List<Reward> findGoldPlannerRewards(List<UUID> detailsIds, List<UUID> typeRewardIds);
}

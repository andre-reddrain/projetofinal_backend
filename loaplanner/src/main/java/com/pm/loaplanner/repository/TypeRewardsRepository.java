package com.pm.loaplanner.repository;

import com.pm.loaplanner.model.TypeRewards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TypeRewardsRepository extends JpaRepository<TypeRewards, UUID> {
}

package com.loaplanner.rewardsservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rewards")
public class Reward {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "is_extra_reward", nullable = false)
    private Boolean isExtraReward;

    @JoinColumn(name = "gate_details_id", nullable = false)
    private UUID gateDetailsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_rewards_id", referencedColumnName = "id", nullable = false)
    private TypeRewards typeRewards;
}

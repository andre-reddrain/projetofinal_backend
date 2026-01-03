package com.pm.loaplanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
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

    @Column(name = "ammount", nullable = false)
    private int ammount;

    @Column(name = "is_extra_reward", nullable = false)
    private Boolean isExtraReward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gate_details_id", referencedColumnName = "id", nullable = false)
    private GateDetails gateDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_rewards_id", referencedColumnName = "id", nullable = false)
    private TypeRewards typeRewards;
}

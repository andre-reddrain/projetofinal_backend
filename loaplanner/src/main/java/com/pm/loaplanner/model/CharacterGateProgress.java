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
@Table(
        name = "character_gate_progress",
        uniqueConstraints = @UniqueConstraint(columnNames = {"character_id", "gate_details_id"})
)
public class CharacterGateProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "taking_gold")
    private Boolean takingGold;

    @Column(name = "buy_extra_loot")
    private Boolean buyExtraLoot;

    @Column(name = "selected")
    private Boolean selected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gate_details_id", referencedColumnName = "id", nullable = false)
    private GateDetails gateDetails;
}

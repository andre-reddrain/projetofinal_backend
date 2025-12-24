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
@Table(name = "gate_details")
public class GateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "entry_lvl")
    private int entryLvl;

    @Column(name = "extraloot_cost")
    private int extralootCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gate_id", referencedColumnName = "id")
    private Gate gate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "difficulty_id", referencedColumnName = "id")
    private Difficulty difficulty;
}

package com.pm.loaplanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
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
    @ToString.Exclude
    private Gate gate;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @ToString.Exclude
    @OneToMany(mappedBy = "gateDetails", fetch = FetchType.LAZY)
    private Set<Reward> rewards = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GateDetails)) return false;
        GateDetails other = (GateDetails) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

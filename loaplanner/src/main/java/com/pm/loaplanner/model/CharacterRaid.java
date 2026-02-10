package com.pm.loaplanner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(
        name = "character_raid",
        uniqueConstraints = @UniqueConstraint(columnNames = {"character_id", "raid_id"})
)
@Getter
@Setter
@NoArgsConstructor
public class CharacterRaid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    private Character character;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raid_id", referencedColumnName = "id", nullable = false)
    private Raid raid;

    @Column(nullable = false)
    private boolean isTracked = false;
}

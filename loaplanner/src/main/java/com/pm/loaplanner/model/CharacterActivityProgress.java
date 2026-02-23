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
@Table(name = "character_activity_progress")
public class CharacterActivityProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "entry_counter", nullable = false)
    private int entryCounter = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id", referencedColumnName = "id", nullable = false)
    private Activity activity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public boolean isCompleted() {
        return activity != null && entryCounter >= activity.getMaxEntries();
    }
}

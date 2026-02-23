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
@Table(name = "character_classes")
public class CharacterClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "type")
    private String type;

    @Column(name = "subtype")
    private String subtype;

    @Column(name = "icon")
    private String icon;
}

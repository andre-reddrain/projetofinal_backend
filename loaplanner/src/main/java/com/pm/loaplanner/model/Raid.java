package com.pm.loaplanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.UUID;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "raids")
public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "icon")
    private String icon;

    //OneToMany
    @OneToMany(mappedBy = "raid", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Gate> gates =  new HashSet<>();
}

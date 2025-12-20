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
@Table(name = "type_rewards")
public class TypeRewards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "tier")
    private int tier;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "grade")
    private String grade;

    @Column(name = "icon")
    private String icon;
}

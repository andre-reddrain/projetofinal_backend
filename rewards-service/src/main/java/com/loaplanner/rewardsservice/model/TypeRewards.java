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
@Table(name = "type_rewards")
public class TypeRewards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "tier")
    private Integer tier;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "grade")
    private String grade;

    @Column(name = "icon")
    private String icon;
}
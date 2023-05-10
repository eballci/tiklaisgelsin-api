package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
public class ExperienceEntity extends AbstractEntity {

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String position;

    @Column
    private String description;

    @Column(nullable = false)
    private LocalDate start;

    @Column
    private LocalDate end;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;
}

package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "education")
public class EducationEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;

    @Column(nullable = false)
    private String study;

    @Column(nullable = false)
    private String institution;

    @Column
    private String description;

    @Column
    private float GPA;

    @Column(nullable = false)
    private LocalDate start;

    @Column
    private LocalDate end;
}

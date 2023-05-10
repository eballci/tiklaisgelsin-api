package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "suggestion")
public class SuggestionEntity extends AbstractEntity {

    @Column(nullable = false)
    private int matchRate;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;
}

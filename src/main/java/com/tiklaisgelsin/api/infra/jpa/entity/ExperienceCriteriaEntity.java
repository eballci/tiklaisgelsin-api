package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "experience_criteria")
public class ExperienceCriteriaEntity extends AbstractEntity {

    @Column(nullable = false)
    private Long positionId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int expectation;

    @OneToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;
}

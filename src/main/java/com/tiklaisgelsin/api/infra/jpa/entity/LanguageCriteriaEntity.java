package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language_criteria")
public class LanguageCriteriaEntity extends AbstractEntity {

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private int expectedLevel;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;
}

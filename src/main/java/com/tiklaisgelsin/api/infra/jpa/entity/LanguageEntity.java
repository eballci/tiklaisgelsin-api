package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language")
public class LanguageEntity extends AbstractEntity {

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private int level;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;
}

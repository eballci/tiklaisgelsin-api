package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employer_avatar")
public class EmployerAvatarEntity extends AbstractEntity {

    @Column(nullable = false, columnDefinition = "text")
    private String file;

    @OneToOne
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;
}

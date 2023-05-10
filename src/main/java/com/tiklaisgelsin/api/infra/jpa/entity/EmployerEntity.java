package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employer")
public class EmployerEntity extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "employer")
    private EmployerAvatarEntity avatar;

    @Column
    private String description;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private int scale;

    @Column
    private String webSite;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<PositionEntity> positions = new LinkedList<>();

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<OfferEntity> offers = new LinkedList<>();

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<SubmissionEntity> submissions = new LinkedList<>();

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<SuggestionEntity> suggestions = new LinkedList<>();
}

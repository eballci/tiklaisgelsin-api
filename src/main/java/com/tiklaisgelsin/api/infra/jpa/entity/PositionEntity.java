package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "position")
public class PositionEntity extends AbstractEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @OneToOne(mappedBy = "position")
    private ExperienceCriteriaEntity experienceCriteria;

    @OneToOne(mappedBy = "position")
    private EducationCriteriaEntity educationCriteria;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<LanguageCriteriaEntity> languageCriterias = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<OfferEntity> offers = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<SubmissionEntity> submissions = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<SuggestionEntity> suggestions = new LinkedList<>();
}

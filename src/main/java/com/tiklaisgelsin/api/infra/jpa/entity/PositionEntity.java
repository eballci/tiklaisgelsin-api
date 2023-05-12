package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.Position;
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

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LanguageCriteriaEntity> languageCriterias = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OfferEntity> offers = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SubmissionEntity> submissions = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SuggestionEntity> suggestions = new LinkedList<>();

    public Position toModel() {

        List<Criteria> criteriaList = new LinkedList<>(
                languageCriterias.stream().map(LanguageCriteriaEntity::toModel).toList()
        );

        if (experienceCriteria != null) {
            criteriaList.add(experienceCriteria.toModel());
        }

        if (educationCriteria != null) {
            criteriaList.add(educationCriteria.toModel());
        }

        return Position.builder()
                .id(getId())
                .title(title)
                .description(description)
                .criteriaList(criteriaList)
                .employerId(employer.getId())
                .build();
    }
}

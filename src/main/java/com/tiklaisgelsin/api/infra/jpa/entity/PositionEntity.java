package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.CriteriaEntity;
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

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CriteriaEntity> criteriaList = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OfferEntity> offers = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SubmissionEntity> submissions = new LinkedList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SuggestionEntity> suggestions = new LinkedList<>();

    public Position toModel() {
        return Position.builder()
                .id(getId())
                .title(title)
                .description(description)
                .criteriaList(criteriaList.stream().map(CriteriaEntity::toModel).toList())
                .employerId(employer.getId())
                .build();
    }
}

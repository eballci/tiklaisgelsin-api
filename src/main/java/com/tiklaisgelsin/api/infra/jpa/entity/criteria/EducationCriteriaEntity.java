package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.EducationCriteria;
import com.tiklaisgelsin.api.domain.common.model.EducationLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "education_criteria")
public class EducationCriteriaEntity extends AbstractEntity {

    @Column(nullable = false)
    private String study;

    @Column(nullable = false)
    private int expectedLevel;

    @OneToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    public EducationCriteria toModel() {
        return EducationCriteria.builder()
                .study(study)
                .minEducationLevel(EducationLevel.generate(expectedLevel))
                .build();
    }
}
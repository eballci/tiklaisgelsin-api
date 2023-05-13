package com.tiklaisgelsin.api.infra.jpa.entity.criteria;

import com.tiklaisgelsin.api.domain.common.model.EducationCriteria;
import com.tiklaisgelsin.api.domain.common.model.EducationLevel;
import com.tiklaisgelsin.api.infra.jpa.entity.AbstractEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "education_criteria")
public class EducationCriteriaEntity extends CriteriaEntity {

    @Column(nullable = false)
    private String study;

    @Column(nullable = false)
    private int expectedLevel;

    public EducationCriteria toModel() {
        return EducationCriteria.builder()
                .study(study)
                .minEducationLevel(EducationLevel.generate(expectedLevel))
                .build();
    }
}
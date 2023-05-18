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
public class EducationCriteriaEntity extends CriteriaEntity {

    private String study;
    private int expectedLevel;

    public EducationCriteria toModel() {
        return EducationCriteria.builder()
                .study(study)
                .minEducationLevel(EducationLevel.generate(expectedLevel))
                .build();
    }
}
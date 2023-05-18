package com.tiklaisgelsin.api.infra.jpa.entity.criteria;

import com.tiklaisgelsin.api.domain.common.model.ExperienceCriteria;
import com.tiklaisgelsin.api.infra.jpa.entity.AbstractEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@Entity
public class ExperienceCriteriaEntity extends CriteriaEntity {

    private String title;
    private int expectation;

    public ExperienceCriteria toModel() {
        return ExperienceCriteria.builder()
                .title(title.trim())
                .minimumYears(expectation)
                .build();
    }
}

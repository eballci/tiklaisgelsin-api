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
@Table(name = "experience_criteria")
public class ExperienceCriteriaEntity extends CriteriaEntity {

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int expectation;

    public ExperienceCriteria toModel() {
        return ExperienceCriteria.builder()
                .titles(Arrays.stream(content.split(",")).toList())
                .minimumYears(expectation)
                .build();
    }
}

package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.ExperienceCriteria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@Entity
@Table(name = "experience_criteria")
public class ExperienceCriteriaEntity extends AbstractEntity {

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int expectation;

    @OneToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    public ExperienceCriteria toModel() {
        return ExperienceCriteria.builder()
                .titles(Arrays.stream(content.split(",")).toList())
                .minimumYears(expectation)
                .build();
    }
}

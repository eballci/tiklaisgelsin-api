package com.tiklaisgelsin.api.infra.jpa.entity.criteria;

import com.tiklaisgelsin.api.domain.common.model.LanguageCriteria;
import com.tiklaisgelsin.api.domain.common.model.LanguageLevel;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language_criteria")
public class LanguageCriteriaEntity extends CriteriaEntity {

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private int expectedLevel;

    public LanguageCriteria toModel() {
        return LanguageCriteria.builder()
                .expectedLanguage(language)
                .expectedLevel(LanguageLevel.generate(expectedLevel))
                .build();
    }
}

package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.LanguageCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageCriteriaResponse implements CriteriaResponse {

    @JsonIgnore
    private final String type = "language";
    private String expectedLanguage;
    private int expectedLevel;

    @Override
    public void fromModel(Criteria c) {
        LanguageCriteria criteria = (LanguageCriteria) c;
        expectedLanguage = criteria.getExpectedLanguage();
        expectedLevel = criteria.getExpectedLevel().getLevel();
    }
}

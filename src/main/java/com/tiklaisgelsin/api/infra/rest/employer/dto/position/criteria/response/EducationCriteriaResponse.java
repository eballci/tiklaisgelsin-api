package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.EducationCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationCriteriaResponse implements CriteriaResponse {

    @JsonIgnore
    private final String type = "education";
    private String study;
    private int minEducationLevel;

    @Override
    public void fromModel(Criteria c) {
        EducationCriteria criteria = (EducationCriteria) c;
        study = criteria.getStudy();
        minEducationLevel = criteria.getMinEducationLevel().getLevel();
    }
}

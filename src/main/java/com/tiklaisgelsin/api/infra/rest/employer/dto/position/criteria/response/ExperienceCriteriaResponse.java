package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.ExperienceCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceCriteriaResponse implements CriteriaResponse {

    @JsonIgnore
    private final String type = "experience";
    private String title;
    private int minimumYears;

    @Override
    public void fromModel(Criteria c) {
        ExperienceCriteria criteria = (ExperienceCriteria) c;
        title = criteria.getTitle();
        minimumYears = criteria.getMinimumYears();
    }
}

package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.EducationCriteria;
import org.springframework.stereotype.Component;

@Component
public class EducationCriteriaResponseCreator implements CriteriaResponseCreator<EducationCriteria> {

    @Override
    public EducationCriteriaResponse getInstance() {
        return new EducationCriteriaResponse();
    }

    @Override
    public boolean isCriteriaMyType(Class<? extends Criteria> concrete) {
        return concrete == EducationCriteria.class;
    }

}

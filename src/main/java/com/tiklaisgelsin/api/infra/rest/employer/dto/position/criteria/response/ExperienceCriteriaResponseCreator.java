package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.ExperienceCriteria;
import org.springframework.stereotype.Component;

@Component
public class ExperienceCriteriaResponseCreator implements CriteriaResponseCreator<ExperienceCriteria> {

    @Override
    public ExperienceCriteriaResponse getInstance() {
        return new ExperienceCriteriaResponse();
    }

    @Override
    public boolean isCriteriaMyType(Class<? extends Criteria> concrete) {
        return concrete == ExperienceCriteria.class;
    }

}

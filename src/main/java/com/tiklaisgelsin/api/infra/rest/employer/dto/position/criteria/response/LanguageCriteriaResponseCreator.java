package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.LanguageCriteria;
import org.springframework.stereotype.Component;

@Component
public class LanguageCriteriaResponseCreator implements CriteriaResponseCreator<LanguageCriteria> {

    @Override
    public LanguageCriteriaResponse getInstance() {
        return new LanguageCriteriaResponse();
    }

    @Override
    public boolean isCriteriaMyType(Class<? extends Criteria> concrete) {
        return concrete == LanguageCriteria.class;
    }

}

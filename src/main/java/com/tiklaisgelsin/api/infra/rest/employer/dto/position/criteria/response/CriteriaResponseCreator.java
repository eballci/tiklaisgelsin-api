package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.tiklaisgelsin.api.domain.common.model.Criteria;

public interface CriteriaResponseCreator<T extends Criteria> {
    CriteriaResponse getInstance();

    boolean isCriteriaMyType(Class<? extends Criteria> concrete);
}

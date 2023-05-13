package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;

public interface CriteriaUseCaseCreator<T extends CreateCriteria> {
    CreateCriteria getUseCaseInstance(CriteriaRequest abstractCriteriaRequest);
    boolean isUseCaseMyType(CriteriaRequest abstractCriteriaRequest);
}

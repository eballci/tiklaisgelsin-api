package com.tiklaisgelsin.api.infra.adapter.employer.criteria;

import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.CriteriaEntity;

public interface CriteriaUseCaseManager<T extends CreateCriteria> {
    CriteriaEntity saveCriteria(CreateCriteria criteria, PositionEntity position);

    void clearCriteriasForPosition(Long positionId);

    boolean isUseCaseMyType(Class<? extends CreateCriteria> concrete);
}

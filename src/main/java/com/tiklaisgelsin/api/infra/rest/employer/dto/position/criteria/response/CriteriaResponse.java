package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.tiklaisgelsin.api.domain.common.model.Criteria;

public interface CriteriaResponse {
    void fromModel(Criteria criteria);

    String getType();
}

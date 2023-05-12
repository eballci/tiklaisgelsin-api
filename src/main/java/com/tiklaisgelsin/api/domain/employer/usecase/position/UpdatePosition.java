package com.tiklaisgelsin.api.domain.employer.usecase.position;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdatePosition implements UseCase {
    private Long positionId;
    private String title;
    private String description;
    private List<CreateCriteria> criteriaList;
}

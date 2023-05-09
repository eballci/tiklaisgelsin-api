package com.tiklaisgelsin.api.domain.employer.usecase.criteria;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UpdateExperienceCriteria implements UseCase {
    private Long experienceCriteriaId;
    private int minimumYears;
    private Set<String> titles;
}

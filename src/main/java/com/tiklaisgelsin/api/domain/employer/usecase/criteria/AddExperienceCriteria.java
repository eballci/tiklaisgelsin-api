package com.tiklaisgelsin.api.domain.employer.usecase.criteria;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AddExperienceCriteria implements UseCase {
    private Long positionId;
    private int minimumYears;
    private Set<String> titles;
}

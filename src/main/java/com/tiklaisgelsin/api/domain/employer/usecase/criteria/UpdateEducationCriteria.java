package com.tiklaisgelsin.api.domain.employer.usecase.criteria;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEducationCriteria implements UseCase {
    private Long educationCriteriaId;
    private String study;
    private int minEducationLevel;
}


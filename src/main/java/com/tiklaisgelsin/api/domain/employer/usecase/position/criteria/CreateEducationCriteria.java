package com.tiklaisgelsin.api.domain.employer.usecase.position.criteria;

import com.tiklaisgelsin.api.domain.common.model.EducationLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateEducationCriteria implements CreateCriteria {
    private String study;
    private EducationLevel minEducationLevel;
}

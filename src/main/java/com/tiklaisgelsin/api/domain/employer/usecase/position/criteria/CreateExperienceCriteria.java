package com.tiklaisgelsin.api.domain.employer.usecase.position.criteria;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateExperienceCriteria implements CreateCriteria {
    private String title;
    private int minimumYears;
}

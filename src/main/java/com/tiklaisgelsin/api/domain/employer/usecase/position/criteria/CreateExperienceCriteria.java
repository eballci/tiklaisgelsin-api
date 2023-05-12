package com.tiklaisgelsin.api.domain.employer.usecase.position.criteria;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateExperienceCriteria implements CreateCriteria {
    private List<String> titles;
    private int minimumYears;
}

package com.tiklaisgelsin.api.domain.employer.usecase.position;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreatePosition {
    private Long employerId;
    private String title;
    private String description;
    private List<Criteria<?>> criteriaList;
}

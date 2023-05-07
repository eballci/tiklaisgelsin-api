package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Position {
    private Long id;
    private Employer employer;
    private String title;
    private String description;
    private List<Criteria<?>> criteriaList;
}

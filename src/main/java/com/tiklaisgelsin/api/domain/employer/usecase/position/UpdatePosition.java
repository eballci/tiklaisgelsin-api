package com.tiklaisgelsin.api.domain.employer.usecase.position;

import com.tiklaisgelsin.api.domain.common.model.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdatePosition implements UseCase {
    private Long positionId;
    private String title;
    private String description;
    private EducationCriteria educationCriteria;
    private ExperienceCriteria experienceCriteria;
    private List<LanguageCriteria> languageCriteriaList;
}

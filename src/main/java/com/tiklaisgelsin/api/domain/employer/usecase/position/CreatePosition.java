package com.tiklaisgelsin.api.domain.employer.usecase.position;

import com.tiklaisgelsin.api.domain.common.model.EducationCriteria;
import com.tiklaisgelsin.api.domain.common.model.ExperienceCriteria;
import com.tiklaisgelsin.api.domain.common.model.LanguageCriteria;
import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreatePosition implements UseCase {
    private Long employerId;
    private String title;
    private String description;
    private EducationCriteria educationCriteria;
    private ExperienceCriteria experienceCriteria;
    private List<LanguageCriteria> languageCriteriaList;
}

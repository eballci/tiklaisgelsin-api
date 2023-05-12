package com.tiklaisgelsin.api.domain.employer.usecase.position.criteria;

import com.tiklaisgelsin.api.domain.common.model.LanguageLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLanguageCriteria implements CreateCriteria {
    private String expectedLanguage;
    private LanguageLevel expectedLevel;
}

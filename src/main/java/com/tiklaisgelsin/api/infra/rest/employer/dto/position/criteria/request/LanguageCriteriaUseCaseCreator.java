package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request;

import com.tiklaisgelsin.api.domain.common.model.LanguageLevel;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateLanguageCriteria;
import com.tiklaisgelsin.api.infra.rest.common.exception.MissingRequestPropertyException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LanguageCriteriaUseCaseCreator implements CriteriaUseCaseCreator<CreateLanguageCriteria> {

    @Override
    public CreateCriteria getUseCaseInstance(CriteriaRequest abstractCriteriaRequest) {
        return CreateLanguageCriteria.builder()
                .expectedLanguage(
                        Optional.ofNullable(abstractCriteriaRequest.getData().get("expectedLanguage"))
                                .map(data -> (String) data)
                                .orElseThrow(() -> new MissingRequestPropertyException(
                                        "Language criteria object must have 'expectedLanguage' property"
                                ))
                )
                .expectedLevel(
                        Optional.ofNullable(abstractCriteriaRequest.getData().get("expectedLevel"))
                                .map(data -> (Integer) data)
                                .map(LanguageLevel::generate)
                                .orElseThrow(() -> new MissingRequestPropertyException(
                                        "Language criteria object must have 'expectedLevel' property"
                                ))
                )
                .build();
    }

    @Override
    public boolean isUseCaseMyType(CriteriaRequest abstractCriteriaRequest) {
        return abstractCriteriaRequest.getType().toLowerCase().compareTo("language") == 0;
    }

}

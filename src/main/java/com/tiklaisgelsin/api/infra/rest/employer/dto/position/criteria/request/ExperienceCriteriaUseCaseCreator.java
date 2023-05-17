package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request;

import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateExperienceCriteria;
import com.tiklaisgelsin.api.infra.rest.common.exception.MissingRequestPropertyException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExperienceCriteriaUseCaseCreator implements CriteriaUseCaseCreator<CreateExperienceCriteria> {

    @Override
    public CreateCriteria getUseCaseInstance(CriteriaRequest abstractCriteriaRequest) {
        return CreateExperienceCriteria.builder()
                .title(
                        Optional.ofNullable(abstractCriteriaRequest.getData().get("title"))
                                .map(data -> (String) data)
                                .orElseThrow(() -> new MissingRequestPropertyException(
                                        "Experience criteria object must have 'titles' property"
                                ))
                )
                .minimumYears(
                        Optional.ofNullable(abstractCriteriaRequest.getData().get("minimumYears"))
                                .map(data -> (Integer) data)
                                .orElseThrow(() -> new MissingRequestPropertyException(
                                        "Experience criteria object must have 'minimumYears' property"
                                ))
                )
                .build();
    }

    @Override
    public boolean isUseCaseMyType(CriteriaRequest abstractCriteriaRequest) {
        return abstractCriteriaRequest.getType().toLowerCase().compareTo("experience") == 0;
    }

}

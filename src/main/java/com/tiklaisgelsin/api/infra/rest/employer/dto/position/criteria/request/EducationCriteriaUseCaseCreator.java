package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request;

import com.tiklaisgelsin.api.domain.common.model.EducationLevel;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateEducationCriteria;
import com.tiklaisgelsin.api.infra.rest.common.exception.MissingRequestPropertyException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EducationCriteriaUseCaseCreator implements CriteriaUseCaseCreator<CreateEducationCriteria> {

    @Override
    public CreateCriteria getUseCaseInstance(CriteriaRequest abstractCriteriaRequest) {
        return CreateEducationCriteria.builder()
                .study(
                        Optional.ofNullable(abstractCriteriaRequest.getData().get("study"))
                                .map(data -> (String) data)
                                .orElseThrow(() -> new MissingRequestPropertyException(
                                        "Education criteria object must have 'study' property"
                                ))
                )
                .minEducationLevel(
                        Optional.ofNullable(abstractCriteriaRequest.getData().get("minEducationLevel"))
                                .map(data -> (Integer) data)
                                .map(EducationLevel::generate)
                                .orElseThrow(() -> new MissingRequestPropertyException(
                                        "Education criteria object must have 'minEducationLevel' property"
                                ))
                )
                .build();
    }

    @Override
    public boolean isUseCaseMyType(CriteriaRequest abstractCriteriaRequest) {
        return abstractCriteriaRequest.getType().toLowerCase().compareTo("education") == 0;
    }

}

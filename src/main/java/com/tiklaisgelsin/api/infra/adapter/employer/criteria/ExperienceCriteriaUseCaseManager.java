package com.tiklaisgelsin.api.infra.adapter.employer.criteria;

import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateExperienceCriteria;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.CriteriaEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.ExperienceCriteriaEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.ExperienceCriteriaJpaRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class ExperienceCriteriaUseCaseManager implements CriteriaUseCaseManager<CreateExperienceCriteria> {

    private final ExperienceCriteriaJpaRepository repository;

    @Override
    public CriteriaEntity saveCriteria(CreateCriteria abstractCriteria, PositionEntity position) {
        CreateExperienceCriteria criteria = (CreateExperienceCriteria) abstractCriteria;
        ExperienceCriteriaEntity c = new ExperienceCriteriaEntity();
        c.setContent(String.join(",", criteria.getTitles()));
        c.setExpectation(criteria.getMinimumYears());
        c.setPosition(position);
        return repository.saveAndFlush(c);
    }

    @Override
    public boolean isUseCaseMyType(Class<? extends CreateCriteria> concrete) {
        return concrete == CreateExperienceCriteria.class;
    }

}

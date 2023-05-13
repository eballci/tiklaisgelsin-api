package com.tiklaisgelsin.api.infra.adapter.employer.criteria;

import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateEducationCriteria;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.CriteriaEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.EducationCriteriaEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EducationCriteriaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EducationCriteriaUseCaseManager implements CriteriaUseCaseManager<CreateEducationCriteria> {

    private final EducationCriteriaJpaRepository repository;

    @Override
    public CriteriaEntity saveCriteria(CreateCriteria abstractCriteria, PositionEntity position) {
        CreateEducationCriteria criteria = (CreateEducationCriteria) abstractCriteria;
        EducationCriteriaEntity c = new EducationCriteriaEntity();
        c.setStudy(criteria.getStudy());
        c.setExpectedLevel(criteria.getMinEducationLevel().getLevel());
        c.setPosition(position);
        return repository.saveAndFlush(c);
    }

    @Override
    public void clearCriteriasForPosition(Long positionId) {
        repository.deleteByPositionId(positionId);
    }

    @Override
    public boolean isUseCaseMyType(Class<? extends CreateCriteria> concrete) {
        return concrete == CreateEducationCriteria.class;
    }

}

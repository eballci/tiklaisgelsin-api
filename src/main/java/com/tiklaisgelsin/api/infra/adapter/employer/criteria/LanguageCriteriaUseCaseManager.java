package com.tiklaisgelsin.api.infra.adapter.employer.criteria;

import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateLanguageCriteria;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.CriteriaEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.criteria.LanguageCriteriaEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.LanguageCriteriaJpaRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class LanguageCriteriaUseCaseManager implements CriteriaUseCaseManager<CreateLanguageCriteria> {

    private final LanguageCriteriaJpaRepository repository;

    @Override
    public CriteriaEntity saveCriteria(CreateCriteria abstractCriteria, PositionEntity position) {
        CreateLanguageCriteria criteria = (CreateLanguageCriteria) abstractCriteria;
        LanguageCriteriaEntity c = new LanguageCriteriaEntity();
        c.setLanguage(criteria.getExpectedLanguage());
        c.setExpectedLevel(criteria.getExpectedLevel().getLevel());
        c.setPosition(position);
        return repository.saveAndFlush(c);
    }

    @Override
    public boolean isUseCaseMyType(Class<? extends CreateCriteria> concrete) {
        return concrete == CreateLanguageCriteria.class;
    }

}

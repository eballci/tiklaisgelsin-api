package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.criteria.LanguageCriteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageCriteriaJpaRepository extends JpaRepository<LanguageCriteriaEntity, Long> {
    void deleteAllByPositionId(Long positionId);
}

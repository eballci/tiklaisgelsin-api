package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.criteria.ExperienceCriteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceCriteriaJpaRepository extends JpaRepository<ExperienceCriteriaEntity, Long> {
}

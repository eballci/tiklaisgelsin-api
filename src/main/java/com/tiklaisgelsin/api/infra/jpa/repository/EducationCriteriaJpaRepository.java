package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.EducationCriteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationCriteriaJpaRepository extends JpaRepository<EducationCriteriaEntity, Long> {
}

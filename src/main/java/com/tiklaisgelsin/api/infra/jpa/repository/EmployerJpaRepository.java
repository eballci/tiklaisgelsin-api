package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerJpaRepository extends JpaRepository<EmployerEntity, Long> {
}

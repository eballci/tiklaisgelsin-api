package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerJpaRepository extends JpaRepository<EmployerEntity, Long> {
    Optional<EmployerEntity> findByEmail(String email);
}

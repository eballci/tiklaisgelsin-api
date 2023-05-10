package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.EmployerAvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerAvatarJpaRepository extends JpaRepository<EmployerAvatarEntity, Long> {
}

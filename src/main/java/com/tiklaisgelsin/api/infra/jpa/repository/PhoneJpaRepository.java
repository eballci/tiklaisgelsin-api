package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneJpaRepository extends JpaRepository<PhoneEntity, Long> {
}

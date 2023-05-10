package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneJpaEntity extends JpaRepository<PhoneEntity, Long> {
}

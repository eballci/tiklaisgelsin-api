package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeekerJpaRepository extends JpaRepository<SeekerEntity, Long> {
}

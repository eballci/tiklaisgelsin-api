package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferJpaRepository extends JpaRepository<OfferEntity, Long> {
    List<OfferEntity> findAllBySeekerId(Long seekerId);
}

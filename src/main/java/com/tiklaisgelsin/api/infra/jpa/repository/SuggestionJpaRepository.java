package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.SuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuggestionJpaRepository extends JpaRepository<SuggestionEntity, Long> {
    Optional<SuggestionEntity> findBySeekerIdAndPositionId(Long seekerId, Long positionId);
}

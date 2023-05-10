package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.SuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionJpaRepository extends JpaRepository<SuggestionEntity, Long> {
    void deleteAllByPositionId(Long positionId);
}

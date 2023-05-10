package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.SubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionJpaRepository extends JpaRepository<SubmissionEntity, Long> {
    List<SubmissionEntity> findAllByEmployerId(Long employerId);
}

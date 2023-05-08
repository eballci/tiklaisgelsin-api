package com.tiklaisgelsin.api.infra.adapters.employer.avatar.jpa.repository;

import com.tiklaisgelsin.api.infra.adapters.employer.avatar.jpa.entity.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarJpaRepository extends JpaRepository<AvatarEntity, Long> {
    AvatarEntity findByEmployerId(Long employerId);
}

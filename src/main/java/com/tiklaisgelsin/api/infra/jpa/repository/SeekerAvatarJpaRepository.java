package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.SeekerAvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeekerAvatarJpaRepository extends JpaRepository<SeekerAvatarEntity, Long> {
}

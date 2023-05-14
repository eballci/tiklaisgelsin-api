package com.tiklaisgelsin.api.infra.jpa.repository;

import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeekerJpaRepository extends JpaRepository<SeekerEntity, Long> {
    Optional<SeekerEntity> findByEmail(String email);

    Optional<SeekerEntity> findByEmailAndPassword(String email, String password);
}

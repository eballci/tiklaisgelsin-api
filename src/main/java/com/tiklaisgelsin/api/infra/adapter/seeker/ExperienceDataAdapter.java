package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Experience;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.AddSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.RemoveSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.UpdateSeekerExperience;
import com.tiklaisgelsin.api.infra.jpa.entity.ExperienceEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.ExperienceJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceDataAdapter implements ExperiencePort {

    private final EntityManagerFactory entityManagerFactory;
    private final SeekerJpaRepository seekerJpaRepository;
    private final ExperienceJpaRepository experienceJpaRepository;

    @Override
    public Experience addExperience(AddSeekerExperience addSeekerExperience) {
        Optional<SeekerEntity> seeker = seekerJpaRepository
                .findById(addSeekerExperience.getSeekerId());

        if (seeker.isEmpty()) return null;

        ExperienceEntity experience = new ExperienceEntity();
        experience.setSeeker(seeker.get());
        experience.setCompany(addSeekerExperience.getCompany());
        experience.setDepartment(addSeekerExperience.getDepartment());
        experience.setPosition(addSeekerExperience.getPosition());
        experience.setDescription(addSeekerExperience.getDescription());
        experience.setStart(addSeekerExperience.getStart());
        experience.setCompletion(addSeekerExperience.getEnd());
        return experienceJpaRepository.save(experience).toModel();
    }

    @Override
    public void updateExperience(UpdateSeekerExperience updateSeekerExperience) {
        Optional<ExperienceEntity> experience = experienceJpaRepository
                .findById(updateSeekerExperience.getExperienceId());

        if (experience.isEmpty()) return;

        experience.get().setCompany(updateSeekerExperience.getCompany());
        experience.get().setDepartment(updateSeekerExperience.getDepartment());
        experience.get().setPosition(updateSeekerExperience.getPosition());
        experience.get().setDescription(updateSeekerExperience.getDescription());
        experience.get().setStart(updateSeekerExperience.getStart());
        experience.get().setCompletion(updateSeekerExperience.getEnd());
        experienceJpaRepository.save(experience.get());
    }

    @Override
    public void removeExperience(RemoveSeekerExperience removeSeekerExperience) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("delete from ExperienceEntity ee where ee.id = :experienceId");
            query.setParameter("experienceId", removeSeekerExperience.getExperienceId());
            query.executeUpdate();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @Override
    public Long getSeekerId(Long experienceId) {
        Optional<ExperienceEntity> experience = experienceJpaRepository.findById(experienceId);

        if (experience.isEmpty()) throw new RuntimeException("The experience doesn't exist");
        return experience.get().getSeeker().getId();
    }
}

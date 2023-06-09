package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.AddSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.RemoveSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.UpdateSeekerEducation;
import com.tiklaisgelsin.api.infra.jpa.entity.EducationEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EducationJpaRepository;
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
public class EducationDataAdapter implements EducationPort {

    private final EntityManagerFactory entityManagerFactory;
    private final SeekerJpaRepository seekerJpaRepository;
    private final EducationJpaRepository educationJpaRepository;

    @Override
    public Education createEducation(AddSeekerEducation useCase) {
        Optional<SeekerEntity> seeker = seekerJpaRepository.findById(useCase.getSeekerId());

        if (seeker.isEmpty()) return null;

        EducationEntity education = new EducationEntity();
        education.setStudy(useCase.getStudy());
        education.setInstitution(useCase.getInstitution());
        education.setDescription(useCase.getDescription());
        education.setStart(useCase.getStart());
        education.setCompletion(useCase.getEnd());
        education.setGPA(useCase.getGPA());
        education.setLevel(useCase.getLevel());
        education.setSeeker(seeker.get());

        return educationJpaRepository.save(education).toModel();
    }

    @Override
    public void updateEducation(UpdateSeekerEducation useCase) {
        Optional<EducationEntity> education = educationJpaRepository.findById(useCase.getEducationId());

        if (education.isEmpty()) return;

        education.get().setStudy(useCase.getStudy());
        education.get().setInstitution(useCase.getInstitution());
        education.get().setDescription(useCase.getDescription());
        education.get().setStart(useCase.getStart());
        education.get().setCompletion(useCase.getEnd());
        education.get().setGPA(useCase.getGPA());
        education.get().setLevel(useCase.getLevel());

        educationJpaRepository.save(education.get());
    }

    @Override
    public void removeEducation(RemoveSeekerEducation useCase) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("delete from EducationEntity ee where ee.id = :educationId");
            query.setParameter("educationId", useCase.getEducationId());
            query.executeUpdate();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @Override
    public Long getSeekerId(Long educationId) {
        Optional<EducationEntity> education = educationJpaRepository.findById(educationId);

        if (education.isEmpty()) throw new RuntimeException("The education doesn't exist.");

        return education.get().getSeeker().getId();
    }
}

package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Language;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.AddSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.RemoveSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;
import com.tiklaisgelsin.api.infra.jpa.entity.LanguageEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.LanguageJpaRepository;
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
public class LanguageDataAdapter implements LanguagePort {

    private final EntityManagerFactory entityManagerFactory;
    private final SeekerJpaRepository seekerJpaRepository;
    private final LanguageJpaRepository languageJpaRepository;

    @Override
    public Language addLanguage(AddSeekerLanguage addSeekerLanguage) {
        Optional<SeekerEntity> seeker = seekerJpaRepository.findById(addSeekerLanguage.getSeekerId());

        if (seeker.isEmpty()) return null;

        LanguageEntity language = new LanguageEntity();
        language.setLanguage(addSeekerLanguage.getName());
        language.setLevel(addSeekerLanguage.getLevel());
        language.setSeeker(seeker.get());
        return languageJpaRepository.save(language).toModel();
    }

    @Override
    public void updateLanguage(UpdateSeekerLanguage updateSeekerLanguage) {
        Optional<LanguageEntity> language = languageJpaRepository.findById(updateSeekerLanguage.getEntityId());

        if (language.isEmpty()) return;

        language.get().setLanguage(updateSeekerLanguage.getLanguage());
        language.get().setLevel(updateSeekerLanguage.getLevel());
        languageJpaRepository.save(language.get());
    }

    @Override
    public void removeLanguage(RemoveSeekerLanguage removeSeekerLanguage) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("delete from LanguageEntity le where le.id = :languageId");
            query.setParameter("languageId", removeSeekerLanguage.getLanguageId());
            query.executeUpdate();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @Override
    public Long getSeekerId(Long languageId) {
        Optional<LanguageEntity> language = languageJpaRepository.findById(languageId);

        if (language.isEmpty()) throw new RuntimeException("The language doesn't exist");
        return language.get().getSeeker().getId();
    }
}

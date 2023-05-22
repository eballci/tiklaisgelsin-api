package com.tiklaisgelsin.api.infra.adapter.common;

import com.tiklaisgelsin.api.domain.common.port.CommonSuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.CreateSuggestion;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SuggestionEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.PositionJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SuggestionJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommonSuggestionDataAdapter implements CommonSuggestionPort {

    private final EntityManagerFactory entityManagerFactory;
    private final SeekerJpaRepository seekerJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final SuggestionJpaRepository suggestionJpaRepository;

    @Override
    public void createSuggestion(CreateSuggestion useCase) {
        Optional<SeekerEntity> seeker = seekerJpaRepository.findById(useCase.getSeekerId());
        Optional<PositionEntity> position = positionJpaRepository.findById(useCase.getPositionId());
        Optional<SuggestionEntity> already = suggestionJpaRepository
                .findBySeekerIdAndPositionId(
                        useCase.getSeekerId(),
                        useCase.getPositionId()
                );

        if (seeker.isEmpty() || position.isEmpty() || already.isPresent()) return;

        SuggestionEntity suggestion = new SuggestionEntity();
        suggestion.setEmployer(position.get().getEmployer());
        suggestion.setPosition(position.get());
        suggestion.setSeeker(seeker.get());
        suggestion.setMatchRate(useCase.getMatchRate());
        suggestionJpaRepository.save(suggestion);
    }

    @Override
    public void clearAllSeekerSuggestions(ClearSeekerSuggestionsForPosition useCase) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("delete from SuggestionEntity se where se.position.id = :positionId");
            query.setParameter("positionId", useCase.getPositionId());
            query.executeUpdate();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }
}

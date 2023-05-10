package com.tiklaisgelsin.api.infra.adapter.common;

import com.tiklaisgelsin.api.domain.common.port.SuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.CreateSuggestion;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SuggestionEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.PositionJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SuggestionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuggestionDataAdapter implements SuggestionPort {

    private final SeekerJpaRepository seekerJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final SuggestionJpaRepository suggestionJpaRepository;

    @Override
    public void createSuggestion(CreateSuggestion useCase) {
        Optional<SeekerEntity> seeker = seekerJpaRepository.findById(useCase.getSeekerId());
        Optional<PositionEntity> position = positionJpaRepository.findById(useCase.getPositionId());

        if (seeker.isEmpty() || position.isEmpty()) return;

        SuggestionEntity suggestion = new SuggestionEntity();
        suggestion.setEmployer(position.get().getEmployer());
        suggestion.setPosition(position.get());
        suggestion.setSeeker(seeker.get());
        suggestion.setMatchRate(useCase.getMatchRate());
        suggestionJpaRepository.save(suggestion);
    }

    @Override
    public void clearAllSeekerSuggestions(ClearSeekerSuggestionsForPosition useCase) {
        suggestionJpaRepository.deleteByPositionId(useCase.getPositionId());
    }
}

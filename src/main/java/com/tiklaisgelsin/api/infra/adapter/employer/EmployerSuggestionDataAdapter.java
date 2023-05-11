package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.common.model.OfferStatus;
import com.tiklaisgelsin.api.domain.employer.port.EmployerSuggestionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.IgnoreSeekerSuggestion;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.OfferSuggestion;
import com.tiklaisgelsin.api.infra.jpa.entity.OfferEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SuggestionEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.OfferJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SuggestionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerSuggestionDataAdapter implements EmployerSuggestionPort {

    private final OfferJpaRepository offerJpaRepository;
    private final SuggestionJpaRepository suggestionJpaRepository;

    @Override
    public Offer offerSuggestion(OfferSuggestion offerSuggestion) {
        Optional<SuggestionEntity> suggestion = suggestionJpaRepository.findById(offerSuggestion.getSuggestionId());

        if (suggestion.isEmpty()) return null;

        OfferEntity offer = new OfferEntity();
        offer.setSeeker(suggestion.get().getSeeker());
        offer.setEmployer(suggestion.get().getEmployer());
        offer.setPosition(suggestion.get().getPosition());
        offer.setStatus(OfferStatus.ISSUED.getLevel());

        return offerJpaRepository.save(offer).toModel();
    }

    @Override
    public void ignoreSeekerSuggestion(IgnoreSeekerSuggestion ignoreSeekerSuggestion) {
        suggestionJpaRepository.deleteById(ignoreSeekerSuggestion.getSuggestionId());
    }
}

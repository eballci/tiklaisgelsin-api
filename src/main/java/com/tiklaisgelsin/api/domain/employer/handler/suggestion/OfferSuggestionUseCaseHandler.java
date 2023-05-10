package com.tiklaisgelsin.api.domain.employer.handler.suggestion;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.SuggestionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.OfferSuggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OfferSuggestionUseCaseHandler implements UseCaseHandler<Offer, OfferSuggestion> {

    private final SuggestionPort suggestionPort;

    @Override
    public Offer handle(OfferSuggestion useCase) {
        return suggestionPort.offerSuggestion(useCase);
    }
}
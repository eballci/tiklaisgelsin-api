package com.tiklaisgelsin.api.domain.employer.handler.suggestion;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerSuggestionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.IgnoreSeekerSuggestion;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.OfferSuggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OfferSuggestionUseCaseHandler implements UseCaseHandler<Offer, OfferSuggestion> {

    private final EmployerSuggestionPort employerSuggestionPort;

    @Override
    public Offer handle(OfferSuggestion useCase) {
        Offer offer = employerSuggestionPort.offerSuggestion(useCase);
        employerSuggestionPort
                .ignoreSeekerSuggestion(IgnoreSeekerSuggestion.builder()
                        .suggestionId(useCase.getSuggestionId())
                        .build());
        return offer;
    }
}

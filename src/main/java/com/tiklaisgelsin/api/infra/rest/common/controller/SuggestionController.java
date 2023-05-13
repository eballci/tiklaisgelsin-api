package com.tiklaisgelsin.api.infra.rest.common.controller;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.common.model.Submission;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.IgnoreSeekerSuggestion;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.OfferSuggestion;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.SubmitSuggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/suggestion/")
public class SuggestionController {

    private final VoidUseCaseHandler<IgnoreSeekerSuggestion> ignoreSuggestionUseCaseHandler;
    private final UseCaseHandler<Offer, OfferSuggestion> offerSuggestionUseCaseHandler;
    private final UseCaseHandler<Submission, SubmitSuggestion> submitSuggestionUseCaseHandler;

    @GetMapping("/ignore/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void ignoreSuggestion(@PathVariable Long id) {
        ignoreSuggestionUseCaseHandler.handle(IgnoreSeekerSuggestion.builder()
                .suggestionId(id)
                .build());
    }

    @GetMapping("/offer/{id}")
    public void offerSuggestion(@PathVariable Long id) {
        offerSuggestionUseCaseHandler.handle(OfferSuggestion.builder()
                .suggestionId(id)
                .build());
    }

    @GetMapping("/submit/{id}")
    public void submitSuggestion(@PathVariable Long id) {
        submitSuggestionUseCaseHandler.handle(SubmitSuggestion.builder()
                .suggestionId(id)
                .build());
    }

}

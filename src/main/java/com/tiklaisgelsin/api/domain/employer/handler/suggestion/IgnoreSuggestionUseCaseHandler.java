package com.tiklaisgelsin.api.domain.employer.handler.suggestion;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.SuggestionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.IgnoreSeekerSuggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IgnoreSuggestionUseCaseHandler implements VoidUseCaseHandler<IgnoreSeekerSuggestion> {

    private final SuggestionPort suggestionPort;

    @Override
    public void handle(IgnoreSeekerSuggestion useCase) {
        suggestionPort.ignoreSeekerSuggestion(useCase);
    }
}

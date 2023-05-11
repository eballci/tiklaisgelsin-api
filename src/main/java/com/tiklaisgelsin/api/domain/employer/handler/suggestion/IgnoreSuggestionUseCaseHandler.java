package com.tiklaisgelsin.api.domain.employer.handler.suggestion;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerSuggestionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.IgnoreSeekerSuggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IgnoreSuggestionUseCaseHandler implements VoidUseCaseHandler<IgnoreSeekerSuggestion> {

    private final EmployerSuggestionPort employerSuggestionPort;

    @Override
    public void handle(IgnoreSeekerSuggestion useCase) {
        employerSuggestionPort.ignoreSeekerSuggestion(useCase);
    }
}

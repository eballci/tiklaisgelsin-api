package com.tiklaisgelsin.api.domain.seeker.handler.suggestion;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerSuggestionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.IgnorePositionSuggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IgnorePositionSuggestionUseCaseHandler implements VoidUseCaseHandler<IgnorePositionSuggestion> {

    private final SeekerSuggestionPort seekerSuggestionPort;

    @Override
    public void handle(IgnorePositionSuggestion useCase) {
        seekerSuggestionPort.ignorePositionSuggestion(useCase);
    }
}

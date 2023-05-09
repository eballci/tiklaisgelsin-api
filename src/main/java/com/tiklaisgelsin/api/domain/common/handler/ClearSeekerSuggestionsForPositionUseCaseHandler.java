package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.port.SuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearSeekerSuggestionsForPositionUseCaseHandler implements VoidUseCaseHandler<ClearSeekerSuggestionsForPosition> {

    private SuggestionPort suggestionPort;

    @Override
    public void handle(ClearSeekerSuggestionsForPosition useCase) {
        suggestionPort.clearAllSeekerSuggestions(useCase);
    }
}

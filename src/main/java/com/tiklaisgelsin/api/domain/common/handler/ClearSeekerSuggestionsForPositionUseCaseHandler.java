package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.port.SuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearSeekerSuggestionsForPositionUseCaseHandler implements UseCaseHandler<Void, ClearSeekerSuggestionsForPosition> {

    private SuggestionPort suggestionPort;

    @Override
    public Void handle(ClearSeekerSuggestionsForPosition useCase) {
        return suggestionPort.clearAllSeekerSuggestions(useCase);
    }
}

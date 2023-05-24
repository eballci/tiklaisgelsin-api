package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.port.CommonSuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.ClearPositionSuggestionsForSeeker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearPositionSuggestionsForSeekerUseCaseHandler {
    private final CommonSuggestionPort suggestionPort;

    public void handle(ClearPositionSuggestionsForSeeker useCase) {
        suggestionPort.clearAllPositionSuggestions(useCase);
    }
}

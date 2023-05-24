package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.port.CommonSuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearSeekerSuggestionsForPositionUseCaseHandler {

    private final CommonSuggestionPort commonSuggestionPort;

    @Async
    public void handle(ClearSeekerSuggestionsForPosition useCase) {
        commonSuggestionPort.clearAllSeekerSuggestions(useCase);
    }
}

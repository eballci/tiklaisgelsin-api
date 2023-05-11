package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.port.CommonSuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearSeekerSuggestionsForPositionUseCaseHandler implements VoidUseCaseHandler<ClearSeekerSuggestionsForPosition> {

    private CommonSuggestionPort commonSuggestionPort;

    @Override
    public void handle(ClearSeekerSuggestionsForPosition useCase) {
        commonSuggestionPort.clearAllSeekerSuggestions(useCase);
    }
}

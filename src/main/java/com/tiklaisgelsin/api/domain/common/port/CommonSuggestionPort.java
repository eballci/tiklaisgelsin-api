package com.tiklaisgelsin.api.domain.common.port;

import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.CreateSuggestion;

public interface CommonSuggestionPort {
    void createSuggestion(CreateSuggestion useCase);

    void clearAllSeekerSuggestions(ClearSeekerSuggestionsForPosition useCase);
}

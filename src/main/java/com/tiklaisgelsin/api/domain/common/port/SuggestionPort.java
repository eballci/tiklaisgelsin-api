package com.tiklaisgelsin.api.domain.common.port;

import com.tiklaisgelsin.api.domain.common.model.PositionSuggestion;
import com.tiklaisgelsin.api.domain.common.model.SeekerSuggestion;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;

public interface SuggestionPort {
    PositionSuggestion createPositionSuggestion(Long positionId, Long seekerId);

    SeekerSuggestion createSeekerSuggestion(Long seekerId, Long positionId);

    void clearAllSeekerSuggestions(ClearSeekerSuggestionsForPosition useCase);
}

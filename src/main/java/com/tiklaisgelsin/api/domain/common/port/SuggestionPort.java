package com.tiklaisgelsin.api.domain.common.port;

import com.tiklaisgelsin.api.domain.common.model.PositionSuggestion;
import com.tiklaisgelsin.api.domain.common.model.SeekerSuggestion;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestPosition;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;

public interface SuggestionPort {
    PositionSuggestion createPositionSuggestion(SuggestPosition suggestPosition);

    SeekerSuggestion createPositionSuggestion(SuggestSeeker suggestSeeker);
}

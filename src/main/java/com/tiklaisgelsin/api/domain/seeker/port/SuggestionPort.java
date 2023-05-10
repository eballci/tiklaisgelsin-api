package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.common.model.Submission;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.IgnorePositionSuggestion;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.SubmitSuggestion;

public interface SuggestionPort {
    Submission submitSuggestion(SubmitSuggestion submitSuggestion);

    void ignorePositionSuggestion(IgnorePositionSuggestion ignorePositionSuggestion);
}

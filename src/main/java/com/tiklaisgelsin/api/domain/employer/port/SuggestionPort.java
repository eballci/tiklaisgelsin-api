package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.IgnoreSeekerSuggestion;
import com.tiklaisgelsin.api.domain.employer.usecase.suggestion.OfferSuggestion;

public interface SuggestionPort {
    Offer offerSuggestion(OfferSuggestion offerSuggestion);

    void ignoreSeekerSuggestion(IgnoreSeekerSuggestion ignoreSeekerSuggestion);
}

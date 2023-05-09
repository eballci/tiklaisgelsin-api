package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.IssueOffer;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;

public interface OfferPort {
    Offer issue(IssueOffer useCase);

    void remove(RemoveOffer useCase);
}

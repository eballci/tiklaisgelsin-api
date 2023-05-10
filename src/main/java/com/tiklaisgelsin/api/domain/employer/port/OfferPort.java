package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;

public interface OfferPort {
    void remove(RemoveOffer useCase);
}

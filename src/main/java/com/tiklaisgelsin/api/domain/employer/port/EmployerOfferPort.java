package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;

public interface EmployerOfferPort {
    void remove(RemoveOffer useCase);
}

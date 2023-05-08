package com.tiklaisgelsin.api.domain.employer.handler.offer;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.OfferPort;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveOfferUseCaseHandler implements UseCaseHandler<Void, RemoveOffer> {

    private final OfferPort offerPort;

    @Override
    public Void handle(RemoveOffer useCase) {
        return offerPort.remove(useCase);
    }
}

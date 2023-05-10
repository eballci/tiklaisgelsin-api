package com.tiklaisgelsin.api.domain.seeker.handler.offer;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.OfferPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.ReadAllOffers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadAllOffersUseCaseHandler implements VoidUseCaseHandler<ReadAllOffers> {

    private final OfferPort offerPort;

    @Override
    public void handle(ReadAllOffers useCase) {
        offerPort.readAllOffers(useCase);
    }
}

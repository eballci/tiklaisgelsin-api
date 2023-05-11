package com.tiklaisgelsin.api.domain.seeker.handler.offer;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerOfferPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.ReadAllOffers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadAllOffersUseCaseHandler implements VoidUseCaseHandler<ReadAllOffers> {

    private final SeekerOfferPort seekerOfferPort;

    @Override
    public void handle(ReadAllOffers useCase) {
        seekerOfferPort.readAllOffers(useCase);
    }
}

package com.tiklaisgelsin.api.domain.seeker.handler.offer;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.OfferPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.AcceptOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AcceptOfferUseCaseHandler implements VoidUseCaseHandler<AcceptOffer> {

    private final OfferPort offerPort;

    @Override
    public void handle(AcceptOffer useCase) {
        offerPort.acceptOffer(useCase);
    }
}

package com.tiklaisgelsin.api.domain.seeker.handler.offer;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerOfferPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.AcceptOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AcceptOfferUseCaseHandler implements VoidUseCaseHandler<AcceptOffer> {

    private final SeekerOfferPort seekerOfferPort;

    @Override
    public void handle(AcceptOffer useCase) {
        seekerOfferPort.acceptOffer(useCase);
    }
}

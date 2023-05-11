package com.tiklaisgelsin.api.domain.seeker.handler.offer;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerOfferPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.RefuseOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefuseOfferUseCaseHandler implements VoidUseCaseHandler<RefuseOffer> {

    private final SeekerOfferPort seekerOfferPort;

    @Override
    public void handle(RefuseOffer useCase) {
        seekerOfferPort.refuseOffer(useCase);
    }
}

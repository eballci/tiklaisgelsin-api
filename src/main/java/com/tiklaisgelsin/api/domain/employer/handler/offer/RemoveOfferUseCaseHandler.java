package com.tiklaisgelsin.api.domain.employer.handler.offer;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerOfferPort;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveOfferUseCaseHandler implements VoidUseCaseHandler<RemoveOffer> {

    private final EmployerOfferPort employerOfferPort;

    @Override
    public void handle(RemoveOffer useCase) {
        employerOfferPort.remove(useCase);
    }
}

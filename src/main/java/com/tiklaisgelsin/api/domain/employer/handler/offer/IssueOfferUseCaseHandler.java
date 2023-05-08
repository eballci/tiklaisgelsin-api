package com.tiklaisgelsin.api.domain.employer.handler.offer;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.OfferPort;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.IssueOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IssueOfferUseCaseHandler implements UseCaseHandler<Offer, IssueOffer> {

    private final OfferPort offerPort;

    @Override
    public Offer handle(IssueOffer useCase) {
        return offerPort.issue(useCase);
    }
}

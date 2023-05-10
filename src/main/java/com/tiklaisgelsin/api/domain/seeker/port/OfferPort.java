package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.seeker.usecase.offer.AcceptOffer;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.ReadAllOffers;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.RefuseOffer;

public interface OfferPort {
    void acceptOffer(AcceptOffer acceptOffer);

    void readAllOffers(ReadAllOffers readAllOffers);

    void refuseOffer(RefuseOffer refuseOffer);
}

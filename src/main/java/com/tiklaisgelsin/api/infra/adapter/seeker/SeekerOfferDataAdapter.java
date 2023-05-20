package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.OfferStatus;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerOfferPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.AcceptOffer;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.ReadAllOffers;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.RefuseOffer;
import com.tiklaisgelsin.api.infra.jpa.entity.OfferEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.OfferJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeekerOfferDataAdapter implements SeekerOfferPort {

    private final OfferJpaRepository repository;

    @Override
    public void acceptOffer(AcceptOffer acceptOffer) {
        Optional<OfferEntity> offer = repository.findById(acceptOffer.getOfferId());

        if (offer.isEmpty()) return;

        offer.get().setStatus(OfferStatus.ACCEPTED.getLevel());
        repository.save(offer.get());
    }

    @Override
    public void readAllOffers(ReadAllOffers readAllOffers) {
        List<OfferEntity> offers = repository.findAllBySeekerId(readAllOffers.getSeekerId());

        offers.stream()
                .filter(offer -> offer.getStatus() == 1)
                .forEach(offer -> {
                    offer.setStatus(OfferStatus.IDLE.getLevel());
                });

        repository.saveAll(offers);
    }

    @Override
    public void refuseOffer(RefuseOffer refuseOffer) {
        Optional<OfferEntity> offer = repository.findById(refuseOffer.getOfferId());

        if (offer.isEmpty()) return;

        offer.get().setStatus(OfferStatus.REFUSED.getLevel());
        repository.save(offer.get());
    }
}

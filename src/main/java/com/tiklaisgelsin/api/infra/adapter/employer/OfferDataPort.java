package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.employer.port.OfferPort;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;
import com.tiklaisgelsin.api.infra.jpa.repository.OfferJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferDataPort implements OfferPort {

    private final OfferJpaRepository repository;

    @Override
    public void remove(RemoveOffer useCase) {
        repository.deleteById(useCase.getOfferId());
    }
}
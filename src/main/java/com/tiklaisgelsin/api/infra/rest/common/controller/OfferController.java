package com.tiklaisgelsin.api.infra.rest.common.controller;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.AcceptOffer;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.ReadAllOffers;
import com.tiklaisgelsin.api.domain.seeker.usecase.offer.RefuseOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offer/")
public class OfferController {

    private final VoidUseCaseHandler<RemoveOffer> removeOfferVoidUseCaseHandler;
    private final VoidUseCaseHandler<AcceptOffer> acceptOfferVoidUseCaseHandler;
    private final VoidUseCaseHandler<ReadAllOffers> readAllOffersVoidUseCaseHandler;
    private final VoidUseCaseHandler<RefuseOffer> refuseOfferVoidUseCaseHandler;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeOffer(@PathVariable Long id) {
        removeOfferVoidUseCaseHandler.handle(RemoveOffer.builder()
                .offerId(id)
                .build());
    }

    @GetMapping("accept/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void acceptOffer(@PathVariable Long id) {
        acceptOfferVoidUseCaseHandler.handle(AcceptOffer.builder()
                .offerId(id)
                .build());
    }

    @GetMapping("read/{seekerId}")
    @ResponseStatus(HttpStatus.OK)
    public void readAllOffers(@PathVariable Long seekerId) {
        readAllOffersVoidUseCaseHandler.handle(ReadAllOffers.builder()
                .seekerId(seekerId)
                .build());
    }

    @GetMapping("refuse/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void refuseOffer(@PathVariable Long id) {
        refuseOfferVoidUseCaseHandler.handle(RefuseOffer.builder()
                .offerId(id)
                .build());
    }

}

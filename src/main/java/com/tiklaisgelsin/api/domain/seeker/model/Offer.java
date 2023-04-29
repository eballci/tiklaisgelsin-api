package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Offer {
    private Long id;
    private Position position;
    private LocalDateTime createdAt;
    private OfferStatus offerStatus;
}

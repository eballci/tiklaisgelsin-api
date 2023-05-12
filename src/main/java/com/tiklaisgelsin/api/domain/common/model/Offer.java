package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Offer {
    private Long id;
    private Long seekerId;
    private Long positionId;
    private LocalDateTime createdAt;
    private OfferStatus offerStatus;
}

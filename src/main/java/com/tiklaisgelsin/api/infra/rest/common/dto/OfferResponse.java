package com.tiklaisgelsin.api.infra.rest.common.dto;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferResponse {
    private Long id;
    private Long positionId;
    private Long seekerId;
    private int status;

    public static OfferResponse fromModel(Offer offer) {
        return OfferResponse.builder()
                .id(offer.getId())
                .positionId(offer.getPositionId())
                .seekerId(offer.getSeekerId())
                .status(offer.getOfferStatus().getLevel())
                .build();
    }
}

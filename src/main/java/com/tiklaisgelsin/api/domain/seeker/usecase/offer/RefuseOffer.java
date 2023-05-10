package com.tiklaisgelsin.api.domain.seeker.usecase.offer;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RefuseOffer implements UseCase {
    private Long offerId;
}

package com.tiklaisgelsin.api.domain.employer.usecase.offer;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveOffer implements UseCase {
    private Long offerId;
}

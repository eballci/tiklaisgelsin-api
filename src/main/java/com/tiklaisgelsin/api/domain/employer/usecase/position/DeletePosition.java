package com.tiklaisgelsin.api.domain.employer.usecase.position;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeletePosition {
    private Long positionId;
}

package com.tiklaisgelsin.api.domain.employer.usecase.position;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeletePosition implements UseCase {
    private Long positionId;
}

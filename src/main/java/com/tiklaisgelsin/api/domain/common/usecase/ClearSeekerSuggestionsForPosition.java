package com.tiklaisgelsin.api.domain.common.usecase;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClearSeekerSuggestionsForPosition implements UseCase {
    private Long positionId;
}

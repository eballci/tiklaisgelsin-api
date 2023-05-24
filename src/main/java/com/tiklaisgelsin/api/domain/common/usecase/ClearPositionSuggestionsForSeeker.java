package com.tiklaisgelsin.api.domain.common.usecase;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClearPositionSuggestionsForSeeker {
    private Long seekerId;
}

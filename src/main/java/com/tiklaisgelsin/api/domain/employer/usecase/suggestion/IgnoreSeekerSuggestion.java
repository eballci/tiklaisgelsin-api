package com.tiklaisgelsin.api.domain.employer.usecase.suggestion;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IgnoreSeekerSuggestion implements UseCase {
    private Long suggestionId;
}

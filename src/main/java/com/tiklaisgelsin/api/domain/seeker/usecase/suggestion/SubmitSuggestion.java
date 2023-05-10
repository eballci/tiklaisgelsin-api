package com.tiklaisgelsin.api.domain.seeker.usecase.suggestion;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubmitSuggestion implements UseCase {
    private Long suggestionId;
}

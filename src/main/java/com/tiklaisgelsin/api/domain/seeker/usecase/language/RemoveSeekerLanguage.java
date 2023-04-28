package com.tiklaisgelsin.api.domain.seeker.usecase.language;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveSeekerLanguage implements UseCase {
    private Long languageId;
}

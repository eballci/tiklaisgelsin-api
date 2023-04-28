package com.tiklaisgelsin.api.domain.seeker.usecase.language;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateSeekerLanguage implements UseCase {
    private Long entityId;
    private String language;
    private int level;
}

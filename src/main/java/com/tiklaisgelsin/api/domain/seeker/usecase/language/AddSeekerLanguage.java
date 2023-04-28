package com.tiklaisgelsin.api.domain.seeker.usecase.language;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddSeekerLanguage implements UseCase {
    private Long seekerId;
    private String name;
    private int level;
}

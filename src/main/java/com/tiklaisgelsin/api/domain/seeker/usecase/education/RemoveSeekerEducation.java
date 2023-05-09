package com.tiklaisgelsin.api.domain.seeker.usecase.education;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveSeekerEducation implements UseCase {
    private Long educationId;
}

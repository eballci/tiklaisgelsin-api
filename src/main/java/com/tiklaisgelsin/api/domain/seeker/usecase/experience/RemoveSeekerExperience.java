package com.tiklaisgelsin.api.domain.seeker.usecase.experience;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveSeekerExperience implements UseCase {
    private Long experienceId;
}

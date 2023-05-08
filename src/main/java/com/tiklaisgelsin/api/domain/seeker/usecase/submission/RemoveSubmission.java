package com.tiklaisgelsin.api.domain.seeker.usecase.submission;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveSubmission implements UseCase {
    private Long submissionId;
}

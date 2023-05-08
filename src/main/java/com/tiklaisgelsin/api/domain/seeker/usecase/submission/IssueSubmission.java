package com.tiklaisgelsin.api.domain.seeker.usecase.submission;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IssueSubmission implements UseCase {
    private Long seekerId;
    private Long positionId;
}

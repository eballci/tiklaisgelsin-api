package com.tiklaisgelsin.api.domain.employer.usecase.submission;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadAllSubmissions implements UseCase {
    private Long employerId;
}

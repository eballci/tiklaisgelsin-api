package com.tiklaisgelsin.api.domain.employer.usecase.employer;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployerGet implements UseCase {
    private Long employerId;
}

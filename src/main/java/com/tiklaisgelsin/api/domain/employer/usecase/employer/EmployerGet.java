package com.tiklaisgelsin.api.domain.employer.usecase.employer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployerGet {
    private Long employerId;
}

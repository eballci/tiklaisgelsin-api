package com.tiklaisgelsin.api.domain.employer.usecase;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEmployerAvatar {
    private Long employerId;
    private String avatar;
}

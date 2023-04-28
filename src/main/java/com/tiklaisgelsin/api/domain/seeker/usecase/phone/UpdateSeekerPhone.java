package com.tiklaisgelsin.api.domain.seeker.usecase.phone;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateSeekerPhone implements UseCase {
    private Long phoneId;
    private String prefix;
    private String number;
}

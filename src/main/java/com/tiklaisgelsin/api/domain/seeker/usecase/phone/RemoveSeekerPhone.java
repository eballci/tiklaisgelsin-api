package com.tiklaisgelsin.api.domain.seeker.usecase.phone;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveSeekerPhone implements UseCase {
    private Long phoneId;
}

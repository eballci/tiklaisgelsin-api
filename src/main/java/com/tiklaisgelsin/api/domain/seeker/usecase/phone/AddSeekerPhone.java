package com.tiklaisgelsin.api.domain.seeker.usecase.phone;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddSeekerPhone implements UseCase {
    private Long seekerId;
    private String prefix;
    private String number;
}

package com.tiklaisgelsin.api.domain.seeker.usecase.seeker;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeekerGet implements UseCase {
    private Long seekerId;
}

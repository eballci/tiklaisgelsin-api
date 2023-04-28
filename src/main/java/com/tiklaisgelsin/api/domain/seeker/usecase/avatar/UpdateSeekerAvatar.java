package com.tiklaisgelsin.api.domain.seeker.usecase.avatar;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateSeekerAvatar implements UseCase {
    private Long seekerId;
    private String avatar;
}

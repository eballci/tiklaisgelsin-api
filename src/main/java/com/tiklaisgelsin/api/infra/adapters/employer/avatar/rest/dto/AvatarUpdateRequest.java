package com.tiklaisgelsin.api.infra.adapters.employer.avatar.rest.dto;

import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvatarUpdateRequest {
    private Long employerId;
    private String avatar;

    public UpdateEmployerAvatar toUseCase() {
        return UpdateEmployerAvatar.builder()
                .employerId(employerId)
                .avatar(avatar)
                .build();
    }
}

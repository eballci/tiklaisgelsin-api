package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;

public interface AvatarPort {
    void updateSeekerAvatar(UpdateEmployerAvatar updateEmployerAvatar);
}

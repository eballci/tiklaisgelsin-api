package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.seeker.usecase.avatar.UpdateSeekerAvatar;

public interface SeekerAvatarPort {
    void updateAvatar(UpdateSeekerAvatar updateSeekerAvatar);
}

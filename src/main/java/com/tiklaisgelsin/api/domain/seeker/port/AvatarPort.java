package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.seeker.usecase.avatar.UpdateSeekerAvatar;

public interface AvatarPort {
    void updateAvatar(UpdateSeekerAvatar updateSeekerAvatar);
}

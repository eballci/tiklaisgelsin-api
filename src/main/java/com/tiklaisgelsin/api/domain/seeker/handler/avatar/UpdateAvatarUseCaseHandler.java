package com.tiklaisgelsin.api.domain.seeker.handler.avatar;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.AvatarPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.avatar.UpdateSeekerAvatar;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateAvatarUseCaseHandler implements UseCaseHandler<Void, UpdateSeekerAvatar> {

    private final AvatarPort avatarPort;

    @Override
    public Void handle(UpdateSeekerAvatar useCase) {
        return avatarPort.updateAvatar(useCase);
    }
}

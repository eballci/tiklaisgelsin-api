package com.tiklaisgelsin.api.domain.seeker.handler.avatar;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.AvatarPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.avatar.UpdateSeekerAvatar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateAvatarUseCaseHandler implements VoidUseCaseHandler<UpdateSeekerAvatar> {

    private final AvatarPort avatarPort;

    @Override
    public void handle(UpdateSeekerAvatar useCase) {
        avatarPort.updateAvatar(useCase);
    }
}

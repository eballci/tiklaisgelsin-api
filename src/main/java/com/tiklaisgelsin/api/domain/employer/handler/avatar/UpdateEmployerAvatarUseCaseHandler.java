package com.tiklaisgelsin.api.domain.employer.handler.avatar;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.AvatarPort;
import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateEmployerAvatarUseCaseHandler implements UseCaseHandler<Void, UpdateEmployerAvatar> {

    private final AvatarPort avatarPort;

    @Override
    public Void handle(UpdateEmployerAvatar useCase) {
        return avatarPort.updateSeekerAvatar(useCase);
    }
}

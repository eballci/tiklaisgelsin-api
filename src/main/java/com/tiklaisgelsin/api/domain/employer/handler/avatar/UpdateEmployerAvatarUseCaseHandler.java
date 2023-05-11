package com.tiklaisgelsin.api.domain.employer.handler.avatar;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerAvatarPort;
import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateEmployerAvatarUseCaseHandler implements VoidUseCaseHandler<UpdateEmployerAvatar> {

    private final EmployerAvatarPort employerAvatarPort;

    @Override
    public void handle(UpdateEmployerAvatar useCase) {
        employerAvatarPort.updateSeekerAvatar(useCase);
    }
}

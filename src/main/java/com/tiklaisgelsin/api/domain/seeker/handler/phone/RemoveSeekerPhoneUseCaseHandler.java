package com.tiklaisgelsin.api.domain.seeker.handler.phone;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.PhonePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.RemoveSeekerPhone;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveSeekerPhoneUseCaseHandler implements UseCaseHandler<Void, RemoveSeekerPhone> {

    private final PhonePort phonePort;

    @Override
    public Void handle(RemoveSeekerPhone useCase) {
        return phonePort.removePhone(useCase);
    }
}

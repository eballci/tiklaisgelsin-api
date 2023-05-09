package com.tiklaisgelsin.api.domain.seeker.handler.phone;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.PhonePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.RemoveSeekerPhone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSeekerPhoneUseCaseHandler implements VoidUseCaseHandler<RemoveSeekerPhone> {

    private final PhonePort phonePort;

    @Override
    public void handle(RemoveSeekerPhone useCase) {
        phonePort.removePhone(useCase);
    }
}

package com.tiklaisgelsin.api.domain.seeker.handler.phone;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.PhonePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.UpdateSeekerPhone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerPhoneUseCaseHandler implements VoidUseCaseHandler<UpdateSeekerPhone> {

    private final PhonePort phonePort;

    @Override
    public void handle(UpdateSeekerPhone useCase) {
        phonePort.updatePhone(useCase);
    }
}

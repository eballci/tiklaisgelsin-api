package com.tiklaisgelsin.api.domain.seeker.handler.phone;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.PhonePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.UpdateSeekerPhone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerPhoneUseCaseHandler implements UseCaseHandler<Void, UpdateSeekerPhone> {

    private final PhonePort phonePort;

    @Override
    public Void handle(UpdateSeekerPhone useCase) {
        return phonePort.updatePhone(useCase);
    }
}

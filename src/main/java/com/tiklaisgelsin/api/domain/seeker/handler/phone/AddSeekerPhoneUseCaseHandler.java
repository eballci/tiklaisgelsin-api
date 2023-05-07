package com.tiklaisgelsin.api.domain.seeker.handler.phone;

import com.tiklaisgelsin.api.domain.common.model.Phone;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.PhonePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.AddSeekerPhone;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddSeekerPhoneUseCaseHandler implements UseCaseHandler<Phone, AddSeekerPhone> {

    private final PhonePort phonePort;

    @Override
    public Phone handle(AddSeekerPhone useCase) {
        return phonePort.addPhone(useCase);
    }
}

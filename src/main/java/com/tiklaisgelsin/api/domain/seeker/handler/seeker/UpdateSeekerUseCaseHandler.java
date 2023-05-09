package com.tiklaisgelsin.api.domain.seeker.handler.seeker;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerUseCaseHandler implements VoidUseCaseHandler<SeekerUpdate> {

    private final SeekerPort seekerPort;

    @Override
    public void handle(SeekerUpdate useCase) {
        seekerPort.updateSeeker(useCase);
    }
}

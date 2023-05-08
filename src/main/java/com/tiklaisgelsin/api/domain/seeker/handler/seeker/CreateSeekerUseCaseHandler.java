package com.tiklaisgelsin.api.domain.seeker.handler.seeker;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSeekerUseCaseHandler implements UseCaseHandler<Seeker, SeekerCreate> {

    private final SeekerPort seekerPort;

    @Override
    public Seeker handle(SeekerCreate useCase) {
        return seekerPort.createSeeker(useCase);
    }
}

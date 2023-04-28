package com.tiklaisgelsin.api.domain.seeker.handler.seeker;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.model.Seeker;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateSeekerUseCaseHandler implements UseCaseHandler<Void, SeekerUpdate> {

    private final SeekerPort seekerPort;

    @Override
    public Void handle(SeekerUpdate useCase) {
        return seekerPort.updateSeeker(useCase);
    }
}

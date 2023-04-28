package com.tiklaisgelsin.api.domain.seeker.handler.seeker;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.model.Seeker;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.GetSeeker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetSeekerUseCaseHandler implements UseCaseHandler<Seeker, GetSeeker> {

    private final SeekerPort seekerPort;

    @Override
    public Seeker handle(GetSeeker useCase) {
        return seekerPort.getSeeker(useCase);
    }
}

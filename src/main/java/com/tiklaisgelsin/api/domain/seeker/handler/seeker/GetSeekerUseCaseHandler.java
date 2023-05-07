package com.tiklaisgelsin.api.domain.seeker.handler.seeker;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerGet;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetSeekerUseCaseHandler implements UseCaseHandler<Seeker, SeekerGet> {

    private final SeekerPort seekerPort;

    @Override
    public Seeker handle(SeekerGet useCase) {
        return seekerPort.getSeeker(useCase);
    }
}

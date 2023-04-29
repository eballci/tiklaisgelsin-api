package com.tiklaisgelsin.api.domain.seeker.handler.seeker;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.model.SeekerForVisitors;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.GetSeekerForVisitor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetSeekerForVisitorUseCaseHandler implements UseCaseHandler<SeekerForVisitors, GetSeekerForVisitor> {

    private final SeekerPort seekerPort;

    @Override
    public SeekerForVisitors handle(GetSeekerForVisitor useCase) {
        return seekerPort.getSeekerForVisitors(useCase);
    }
}

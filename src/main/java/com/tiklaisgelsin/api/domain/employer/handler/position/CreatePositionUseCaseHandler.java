package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.CreatePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePositionUseCaseHandler implements UseCaseHandler<Position, CreatePosition> {

    private final PositionPort positionPort;

    @Override
    public Position handle(CreatePosition useCase) {
        return positionPort.createPosition(useCase);
    }
}

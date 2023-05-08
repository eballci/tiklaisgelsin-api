package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.UpdatePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdatePositionUseCaseHandler implements UseCaseHandler<Void, UpdatePosition> {

    private final PositionPort positionPort;

    @Override
    public Void handle(UpdatePosition useCase) {
        return positionPort.updatePosition(useCase);
    }
}

package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.UpdatePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdatePositionUseCaseHandler implements VoidUseCaseHandler<UpdatePosition> {

    private final PositionPort positionPort;

    @Override
    public void handle(UpdatePosition useCase) {
        positionPort.updatePosition(useCase);
    }
}

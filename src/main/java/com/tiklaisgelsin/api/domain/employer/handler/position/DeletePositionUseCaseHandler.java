package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.DeletePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePositionUseCaseHandler implements VoidUseCaseHandler<DeletePosition> {

    private final PositionPort positionPort;

    @Override
    public void handle(DeletePosition useCase) {
        positionPort.removePosition(useCase);
    }
}

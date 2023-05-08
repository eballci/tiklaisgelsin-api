package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.DeletePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePositionUseCaseHandler implements UseCaseHandler<Void, DeletePosition> {

    private final PositionPort positionPort;

    @Override
    public Void handle(DeletePosition useCase) {
        return positionPort.removePosition(useCase);
    }
}

package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.exception.MissingEntityException;
import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.GetPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPositionUseCaseHandler implements UseCaseHandler<Position, GetPosition> {

    private final PositionPort positionPort;

    @Override
    public Position handle(GetPosition useCase) {
        return Optional
                .ofNullable(positionPort.getPosition(useCase.getPositionId()))
                .orElseThrow(() ->
                        new MissingEntityException("Cannot transmit position. The specified position does not exist."));
    }
}

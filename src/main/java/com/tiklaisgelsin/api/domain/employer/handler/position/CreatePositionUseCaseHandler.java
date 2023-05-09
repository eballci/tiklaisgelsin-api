package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestPosition;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.CreatePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePositionUseCaseHandler implements UseCaseHandler<Position, CreatePosition> {

    private final PositionPort positionPort;
    private final VoidUseCaseHandler<SuggestPosition> handler;

    @Override
    public Position handle(CreatePosition useCase) {
        Position position = positionPort.createPosition(useCase);

        handler.handle(SuggestPosition
                .builder()
                .positionId(position.getId())
                .build()
        );

        return position;
    }
}

package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestPosition;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.UpdatePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdatePositionUseCaseHandler implements VoidUseCaseHandler<UpdatePosition> {

    private final PositionPort positionPort;
    private final VoidUseCaseHandler<SuggestPosition> handler;
    private final VoidUseCaseHandler<ClearSeekerSuggestionsForPosition> clearHandler;

    @Override
    public void handle(UpdatePosition useCase) {
        clearHandler.handle(ClearSeekerSuggestionsForPosition
                .builder()
                .positionId(useCase.getPositionId())
                .build()
        );
        positionPort.updatePosition(useCase);
        handler.handle(SuggestPosition
                .builder()
                .positionId(useCase.getPositionId())
                .build()
        );
    }
}

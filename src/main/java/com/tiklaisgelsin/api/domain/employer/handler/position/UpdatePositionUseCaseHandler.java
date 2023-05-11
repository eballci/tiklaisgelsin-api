package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.exception.MissingEntityException;
import com.tiklaisgelsin.api.domain.common.handler.ClearSeekerSuggestionsForPositionUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.handler.SuggestPositionUseCaseHandler;
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
    private final SuggestPositionUseCaseHandler handler;
    private final ClearSeekerSuggestionsForPositionUseCaseHandler clearHandler;

    @Override
    public void handle(UpdatePosition useCase) {
        if (positionPort.checkIfPositionDoesntExist(useCase.getPositionId())) {
            throw new MissingEntityException("Cannot update position. The specified position does not exist.");
        }
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

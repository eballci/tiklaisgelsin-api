package com.tiklaisgelsin.api.domain.employer.handler.position;

import com.tiklaisgelsin.api.domain.common.exception.MissingEntityException;
import com.tiklaisgelsin.api.domain.common.handler.ClearSeekerSuggestionsForPositionUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.ClearSeekerSuggestionsForPosition;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.DeletePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePositionUseCaseHandler implements VoidUseCaseHandler<DeletePosition> {

    private final PositionPort positionPort;
    private final ClearSeekerSuggestionsForPositionUseCaseHandler handler;

    @Override
    public void handle(DeletePosition useCase) {
        if (positionPort.checkIfPositionDoesntExist(useCase.getPositionId())) {
            throw new MissingEntityException("Cannot delete position. The specified position does not exist.");
        }
        handler.handle(ClearSeekerSuggestionsForPosition
                .builder()
                .positionId(useCase.getPositionId())
                .build()
        );

        positionPort.removePosition(useCase);
    }
}

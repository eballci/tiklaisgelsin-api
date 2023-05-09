package com.tiklaisgelsin.api.domain.employer.handler.position;

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
    private final VoidUseCaseHandler<ClearSeekerSuggestionsForPosition> handler;

    @Override
    public void handle(DeletePosition useCase) {
        handler.handle(ClearSeekerSuggestionsForPosition
                .builder()
                .positionId(useCase.getPositionId())
                .build()
        );

        positionPort.removePosition(useCase);
    }
}

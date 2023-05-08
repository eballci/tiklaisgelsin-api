package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.common.port.SuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerGet;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

@RequiredArgsConstructor
public class SuggestSeekerUseCaseHandler implements UseCaseHandler<Future<?>, SuggestSeeker> {

    private final PositionPort positionPort;
    private final SeekerPort seekerPort;
    private final SuggestionPort suggestionPort;

    @Async
    @Override
    public Future<?> handle(SuggestSeeker useCase) {
        List<Position> positions = positionPort.getAllPositions();
        Seeker seeker = seekerPort.getSeeker(SeekerGet.builder().seekerId(useCase.getSeekerId()).build());

        for (Position position : positions) {
            int sum = 0;

            for (Criteria criteria : position.getCriteriaList()) {
                sum += criteria.getPoint(seeker);
            }

            if (sum / position.getCriteriaList().size() >= 50) {
                suggestionPort.createPositionSuggestion(position.getId(), seeker.getId());
                suggestionPort.createSeekerSuggestion(seeker.getId(), position.getId());
            }
        }

        return null;
    }
}

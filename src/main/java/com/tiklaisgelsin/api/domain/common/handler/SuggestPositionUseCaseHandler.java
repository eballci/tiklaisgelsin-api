package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.common.port.SuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.CreateSuggestion;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestPosition;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SuggestPositionUseCaseHandler implements VoidUseCaseHandler<SuggestPosition> {

    private final PositionPort positionPort;
    private final SeekerPort seekerPort;
    private final SuggestionPort suggestionPort;

    @Async
    @Override
    public void handle(SuggestPosition useCase) {
        Position position = positionPort.getPosition(useCase.getPositionId());
        List<Seeker> seekers = seekerPort.getAllSeekers();

        for (Seeker seeker : seekers) {
            int sum = 0;

            for (Criteria criteria : position.getCriteriaList()) {
                sum += criteria.getPoint(seeker);
            }

            if (sum / position.getCriteriaList().size() >= 50) {
                suggestionPort.createSuggestion(
                        CreateSuggestion.builder()
                                .positionId(position.getId())
                                .seekerId(seeker.getId())
                                .matchRate(sum / position.getCriteriaList().size())
                                .build()
                );
            }
        }
    }
}

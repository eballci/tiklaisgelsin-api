package com.tiklaisgelsin.api.domain.common.handler;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.common.port.CommonSuggestionPort;
import com.tiklaisgelsin.api.domain.common.usecase.CreateSuggestion;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerGet;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SuggestSeekerUseCaseHandler implements VoidUseCaseHandler<SuggestSeeker> {

    private final PositionPort positionPort;
    private final SeekerPort seekerPort;
    private final CommonSuggestionPort commonSuggestionPort;

    @Async
    @Override
    public void handle(SuggestSeeker useCase) {
        List<Position> positions = positionPort.getAllPositions();
        Seeker seeker = seekerPort.getSeeker(SeekerGet.builder().seekerId(useCase.getSeekerId()).build());

        for (Position position : positions) {
            int sum = 0;

            for (Criteria criteria : position.getCriteriaList()) {
                sum += criteria.getPoint(seeker);
            }

            if (sum / position.getCriteriaList().size() >= 50) {
                commonSuggestionPort.createSuggestion(
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

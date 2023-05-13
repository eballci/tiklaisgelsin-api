package com.tiklaisgelsin.api.domain.seeker.handler.suggestion;

import com.tiklaisgelsin.api.domain.common.model.Submission;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerSuggestionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.IgnorePositionSuggestion;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.SubmitSuggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmitSuggestionUseCaseHandler implements UseCaseHandler<Submission, SubmitSuggestion> {

    private final SeekerSuggestionPort seekerSuggestionPort;

    @Override
    public Submission handle(SubmitSuggestion useCase) {
        Submission submission = seekerSuggestionPort.submitSuggestion(useCase);
        seekerSuggestionPort
                .ignorePositionSuggestion(IgnorePositionSuggestion.builder()
                        .suggestionId(useCase.getSuggestionId())
                        .build());
        return submission;
    }
}

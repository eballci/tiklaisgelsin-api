package com.tiklaisgelsin.api.domain.seeker.handler.language;

import com.tiklaisgelsin.api.domain.common.handler.ClearPositionSuggestionsForSeekerUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.handler.SuggestSeekerUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.ClearPositionSuggestionsForSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerLanguageUseCaseHandler implements VoidUseCaseHandler<UpdateSeekerLanguage> {

    private final LanguagePort languagePort;
    private final SuggestSeekerUseCaseHandler handler;
    private final ClearPositionSuggestionsForSeekerUseCaseHandler clearHandler;

    @Override
    public void handle(UpdateSeekerLanguage useCase) {
        Long seekerId = languagePort.getSeekerId(useCase.getEntityId());

        languagePort.updateLanguage(useCase);
        clearHandler.handle(ClearPositionSuggestionsForSeeker
                .builder()
                .seekerId(seekerId)
                .build());
        handler.handle(SuggestSeeker.builder()
                .seekerId(seekerId)
                .build());
    }
}

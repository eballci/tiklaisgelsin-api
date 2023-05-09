package com.tiklaisgelsin.api.domain.seeker.handler.language;

import com.tiklaisgelsin.api.domain.common.model.Language;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.AddSeekerLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddSeekerLanguageUseCaseHandler implements UseCaseHandler<Language, AddSeekerLanguage> {

    private final LanguagePort languagePort;
    private final VoidUseCaseHandler<SuggestSeeker> handler;

    @Override
    public Language handle(AddSeekerLanguage useCase) {
        Language language = languagePort.addLanguage(useCase);

        handler.handle(SuggestSeeker
                .builder()
                .seekerId(useCase.getSeekerId())
                .build()
        );

        return language;
    }
}

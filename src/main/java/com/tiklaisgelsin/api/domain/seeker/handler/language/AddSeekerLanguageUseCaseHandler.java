package com.tiklaisgelsin.api.domain.seeker.handler.language;

import com.tiklaisgelsin.api.domain.common.model.Language;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.AddSeekerLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddSeekerLanguageUseCaseHandler implements UseCaseHandler<Language, AddSeekerLanguage> {

    private final LanguagePort languagePort;

    @Override
    public Language handle(AddSeekerLanguage useCase) {
        return languagePort.addLanguage(useCase);
    }
}

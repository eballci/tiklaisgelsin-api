package com.tiklaisgelsin.api.domain.seeker.handler.language;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerLanguageUseCaseHandler implements UseCaseHandler<Void, UpdateSeekerLanguage> {

    private final LanguagePort languagePort;

    @Override
    public Void handle(UpdateSeekerLanguage useCase) {
        return languagePort.updateLanguage(useCase);
    }
}

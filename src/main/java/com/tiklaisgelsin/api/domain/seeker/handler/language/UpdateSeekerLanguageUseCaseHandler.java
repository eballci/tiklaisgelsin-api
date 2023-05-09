package com.tiklaisgelsin.api.domain.seeker.handler.language;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerLanguageUseCaseHandler implements VoidUseCaseHandler<UpdateSeekerLanguage> {

    private final LanguagePort languagePort;

    @Override
    public void handle(UpdateSeekerLanguage useCase) {
        languagePort.updateLanguage(useCase);
    }
}

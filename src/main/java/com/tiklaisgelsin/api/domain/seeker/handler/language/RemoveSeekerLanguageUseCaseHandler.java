package com.tiklaisgelsin.api.domain.seeker.handler.language;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.RemoveSeekerLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSeekerLanguageUseCaseHandler implements VoidUseCaseHandler<RemoveSeekerLanguage> {

    private final LanguagePort languagePort;

    @Override
    public void handle(RemoveSeekerLanguage useCase) {
        languagePort.removeLanguage(useCase);
    }
}

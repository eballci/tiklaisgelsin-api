package com.tiklaisgelsin.api.domain.seeker.handler.language;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.RemoveSeekerLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSeekerLanguageUseCaseHandler implements UseCaseHandler<Void, RemoveSeekerLanguage> {

    private final LanguagePort languagePort;

    @Override
    public Void handle(RemoveSeekerLanguage useCase) {
        return languagePort.removeLanguage(useCase);
    }
}

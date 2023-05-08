package com.tiklaisgelsin.api.domain.seeker.handler.experience;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.RemoveSeekerExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSeekerExperienceUseCaseHandler implements UseCaseHandler<Void, RemoveSeekerExperience> {

    private final ExperiencePort experiencePort;


    @Override
    public Void handle(RemoveSeekerExperience useCase) {
        return experiencePort.removeExperience(useCase);
    }
}

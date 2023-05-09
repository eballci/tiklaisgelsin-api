package com.tiklaisgelsin.api.domain.seeker.handler.experience;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.RemoveSeekerExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSeekerExperienceUseCaseHandler implements VoidUseCaseHandler<RemoveSeekerExperience> {

    private final ExperiencePort experiencePort;


    @Override
    public void handle(RemoveSeekerExperience useCase) {
        experiencePort.removeExperience(useCase);
    }
}

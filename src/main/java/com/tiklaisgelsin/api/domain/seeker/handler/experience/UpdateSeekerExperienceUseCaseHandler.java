package com.tiklaisgelsin.api.domain.seeker.handler.experience;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.UpdateSeekerExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerExperienceUseCaseHandler implements VoidUseCaseHandler<UpdateSeekerExperience> {

    private final ExperiencePort experiencePort;

    @Override
    public void handle(UpdateSeekerExperience useCase) {
        experiencePort.updateExperience(useCase);
    }
}

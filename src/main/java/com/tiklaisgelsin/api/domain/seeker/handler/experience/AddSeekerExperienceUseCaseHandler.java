package com.tiklaisgelsin.api.domain.seeker.handler.experience;

import com.tiklaisgelsin.api.domain.common.model.Experience;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.AddSeekerExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddSeekerExperienceUseCaseHandler implements UseCaseHandler<Experience, AddSeekerExperience> {

    private final ExperiencePort experiencePort;


    @Override
    public Experience handle(AddSeekerExperience useCase) {
        return experiencePort.addExperience(useCase);
    }
}

package com.tiklaisgelsin.api.domain.seeker.handler.experience;

import com.tiklaisgelsin.api.domain.common.model.Experience;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.AddSeekerExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddSeekerExperienceUseCaseHandler implements UseCaseHandler<Experience, AddSeekerExperience> {

    private final ExperiencePort experiencePort;
    private final VoidUseCaseHandler<SuggestSeeker> handler;

    @Override
    public Experience handle(AddSeekerExperience useCase) {
        Experience experience = experiencePort.addExperience(useCase);

        handler.handle(SuggestSeeker
                .builder()
                .seekerId(useCase.getSeekerId())
                .build()
        );

        return experience;
    }
}

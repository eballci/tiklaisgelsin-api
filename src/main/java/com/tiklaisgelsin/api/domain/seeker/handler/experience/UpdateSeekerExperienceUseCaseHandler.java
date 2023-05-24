package com.tiklaisgelsin.api.domain.seeker.handler.experience;

import com.tiklaisgelsin.api.domain.common.handler.ClearPositionSuggestionsForSeekerUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.handler.SuggestSeekerUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.ClearPositionSuggestionsForSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.UpdateSeekerExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerExperienceUseCaseHandler implements VoidUseCaseHandler<UpdateSeekerExperience> {

    private final ExperiencePort experiencePort;
    private final SuggestSeekerUseCaseHandler handler;
    private final ClearPositionSuggestionsForSeekerUseCaseHandler clearHandler;

    @Override
    public void handle(UpdateSeekerExperience useCase) {
        Long seekerId = experiencePort.getSeekerId(useCase.getExperienceId());

        experiencePort.updateExperience(useCase);
        clearHandler.handle(ClearPositionSuggestionsForSeeker
                .builder()
                .seekerId(seekerId)
                .build());
        handler.handle(SuggestSeeker.builder()
                .seekerId(seekerId)
                .build());
    }
}

package com.tiklaisgelsin.api.domain.seeker.handler.education;

import com.tiklaisgelsin.api.domain.common.handler.ClearPositionSuggestionsForSeekerUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.handler.SuggestSeekerUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.ClearPositionSuggestionsForSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.UpdateSeekerEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerEducationUseCaseHandler implements VoidUseCaseHandler<UpdateSeekerEducation> {

    private final EducationPort educationPort;
    private final SuggestSeekerUseCaseHandler handler;
    private final ClearPositionSuggestionsForSeekerUseCaseHandler clearHandler;

    @Override
    public void handle(UpdateSeekerEducation useCase) {
        Long seekerId = educationPort.getSeekerId(useCase.getEducationId());

        educationPort.updateEducation(useCase);
        clearHandler.handle(ClearPositionSuggestionsForSeeker
                .builder()
                .seekerId(seekerId)
                .build());
        handler.handle(SuggestSeeker.builder()
                .seekerId(seekerId)
                .build());
    }
}

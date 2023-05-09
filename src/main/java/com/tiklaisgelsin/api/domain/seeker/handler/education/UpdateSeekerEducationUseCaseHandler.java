package com.tiklaisgelsin.api.domain.seeker.handler.education;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.UpdateSeekerEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSeekerEducationUseCaseHandler implements UseCaseHandler<Void, UpdateSeekerEducation> {

    private final EducationPort educationPort;

    @Override
    public Void handle(UpdateSeekerEducation useCase) {
        return educationPort.updateEducation(useCase);
    }
}

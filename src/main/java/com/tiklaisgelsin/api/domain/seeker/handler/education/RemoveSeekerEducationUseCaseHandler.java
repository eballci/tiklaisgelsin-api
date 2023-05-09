package com.tiklaisgelsin.api.domain.seeker.handler.education;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.RemoveSeekerEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSeekerEducationUseCaseHandler implements UseCaseHandler<Void, RemoveSeekerEducation> {

    private final EducationPort educationPort;

    @Override
    public Void handle(RemoveSeekerEducation useCase) {
        return educationPort.removeEducation(useCase);
    }
}

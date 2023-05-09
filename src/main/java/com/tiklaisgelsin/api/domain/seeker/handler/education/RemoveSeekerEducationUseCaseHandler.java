package com.tiklaisgelsin.api.domain.seeker.handler.education;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.RemoveSeekerEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSeekerEducationUseCaseHandler implements VoidUseCaseHandler<RemoveSeekerEducation> {

    private final EducationPort educationPort;

    @Override
    public void handle(RemoveSeekerEducation useCase) {
        educationPort.removeEducation(useCase);
    }
}

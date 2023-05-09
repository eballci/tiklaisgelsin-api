package com.tiklaisgelsin.api.domain.seeker.handler.education;

import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.AddSeekerEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddSeekerEducationUseCaseHandler implements UseCaseHandler<Education, AddSeekerEducation> {

    private final EducationPort educationPort;

    @Override
    public Education handle(AddSeekerEducation useCase) {
        return educationPort.createEducation(useCase);
    }
}

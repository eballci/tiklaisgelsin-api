package com.tiklaisgelsin.api.domain.seeker.handler.education;

import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.AddSeekerEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddSeekerEducationUseCaseHandler implements UseCaseHandler<Education, AddSeekerEducation> {

    private final EducationPort educationPort;
    private final VoidUseCaseHandler<SuggestSeeker> handler;

    @Override
    public Education handle(AddSeekerEducation useCase) {
        Education education = educationPort.createEducation(useCase);
        handler.handle(SuggestSeeker
                .builder()
                .seekerId(useCase.getSeekerId())
                .build()
        );
        return education;
    }
}

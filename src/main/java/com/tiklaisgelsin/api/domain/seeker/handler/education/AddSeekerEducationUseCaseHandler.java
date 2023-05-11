package com.tiklaisgelsin.api.domain.seeker.handler.education;

import com.tiklaisgelsin.api.domain.common.handler.SuggestSeekerUseCaseHandler;
import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.common.usecase.SuggestSeeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.AddSeekerEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@RequiredArgsConstructor
public class AddSeekerEducationUseCaseHandler implements UseCaseHandler<Education, AddSeekerEducation> {

    private final EducationPort educationPort;
    private final SuggestSeekerUseCaseHandler handler;

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

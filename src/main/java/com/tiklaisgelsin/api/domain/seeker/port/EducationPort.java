package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.AddSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.RemoveSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.UpdateSeekerEducation;

public interface EducationPort {
    Education createEducation(AddSeekerEducation useCase);

    void updateEducation(UpdateSeekerEducation useCase);

    void removeEducation(RemoveSeekerEducation useCase);
}

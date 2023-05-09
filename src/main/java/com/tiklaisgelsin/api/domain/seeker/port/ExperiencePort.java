package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.common.model.Experience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.AddSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.RemoveSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.UpdateSeekerExperience;

public interface ExperiencePort {
    Experience addExperience(AddSeekerExperience addSeekerExperience);

    void updateExperience(UpdateSeekerExperience updateSeekerExperience);

    void removeExperience(RemoveSeekerExperience removeSeekerExperience);
}

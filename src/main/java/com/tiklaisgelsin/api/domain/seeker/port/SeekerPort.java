package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.seeker.model.Seeker;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerCreate;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;

public interface SeekerPort {
    Seeker createSeeker(SeekerCreate seekerCreate);

    void updateSeeker(SeekerUpdate seekerUpdate);
}

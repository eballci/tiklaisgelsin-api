package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.seeker.model.Seeker;
import com.tiklaisgelsin.api.domain.seeker.model.SeekerForVisitors;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.GetSeeker;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.GetSeekerForVisitor;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerCreate;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;

public interface SeekerPort {
    Seeker getSeeker(GetSeeker getSeeker);

    SeekerForVisitors getSeekerForVisitors(GetSeekerForVisitor getSeekerForVisitor);

    Seeker createSeeker(SeekerCreate seekerCreate);

    Void updateSeeker(SeekerUpdate seekerUpdate);
}

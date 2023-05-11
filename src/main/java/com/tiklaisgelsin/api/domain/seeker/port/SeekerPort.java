package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerCreate;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerGet;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;

import java.util.List;

public interface SeekerPort {
    Seeker getSeeker(SeekerGet getSeeker);

    Seeker createSeeker(SeekerCreate seekerCreate);

    void updateSeeker(SeekerUpdate seekerUpdate);

    List<Seeker> getAllSeekers();

    boolean checkIfSeekerAlreadyExists(String email);
}

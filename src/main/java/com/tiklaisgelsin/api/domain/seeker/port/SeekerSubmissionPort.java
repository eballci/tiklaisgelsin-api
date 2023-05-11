package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;

public interface SeekerSubmissionPort {
    void removeSubmission(RemoveSubmission removeSubmission);
}

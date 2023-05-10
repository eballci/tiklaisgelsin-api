package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.employer.usecase.submission.AcceptSubmission;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.ReadAllSubmissions;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.RefuseSubmission;

public interface SubmissionPort {
    void acceptSubmission(AcceptSubmission acceptSubmission);

    void readAllSubmissions(ReadAllSubmissions readAllSubmissions);

    void refuseSubmission(RefuseSubmission refuseSubmission);
}

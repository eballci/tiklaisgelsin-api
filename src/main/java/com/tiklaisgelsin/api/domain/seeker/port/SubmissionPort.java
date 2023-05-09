package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.common.model.Submission;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.IssueSubmission;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;

public interface SubmissionPort {
    Submission issueSubmission(IssueSubmission issueSubmission);

    void removeSubmission(RemoveSubmission removeSubmission);
}

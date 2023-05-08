package com.tiklaisgelsin.api.domain.seeker.handler.submission;

import com.tiklaisgelsin.api.domain.common.model.Submission;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SubmissionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.IssueSubmission;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IssueSubmissionUseCaseHandler implements UseCaseHandler<Submission, IssueSubmission> {

    private final SubmissionPort submissionPort;

    @Override
    public Submission handle(IssueSubmission useCase) {
        return submissionPort.issueSubmission(useCase);
    }
}

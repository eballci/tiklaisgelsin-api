package com.tiklaisgelsin.api.domain.employer.handler.submission;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.SubmissionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.AcceptSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AcceptSubmissionUseCaseHandler implements VoidUseCaseHandler<AcceptSubmission> {

    private final SubmissionPort submissionPort;

    @Override
    public void handle(AcceptSubmission useCase) {
        submissionPort.acceptSubmission(useCase);
    }
}

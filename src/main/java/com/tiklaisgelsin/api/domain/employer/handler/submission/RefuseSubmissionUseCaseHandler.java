package com.tiklaisgelsin.api.domain.employer.handler.submission;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.SubmissionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.RefuseSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefuseSubmissionUseCaseHandler implements VoidUseCaseHandler<RefuseSubmission> {

    private final SubmissionPort submissionPort;

    @Override
    public void handle(RefuseSubmission useCase) {
        submissionPort.refuseSubmission(useCase);
    }
}

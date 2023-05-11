package com.tiklaisgelsin.api.domain.employer.handler.submission;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerSubmissionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.AcceptSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AcceptSubmissionUseCaseHandler implements VoidUseCaseHandler<AcceptSubmission> {

    private final EmployerSubmissionPort employerSubmissionPort;

    @Override
    public void handle(AcceptSubmission useCase) {
        employerSubmissionPort.acceptSubmission(useCase);
    }
}

package com.tiklaisgelsin.api.domain.employer.handler.submission;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerSubmissionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.ReadAllSubmissions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadAllSubmissionsUseCaseHandler implements VoidUseCaseHandler<ReadAllSubmissions> {

    private final EmployerSubmissionPort employerSubmissionPort;

    @Override
    public void handle(ReadAllSubmissions useCase) {
        employerSubmissionPort.readAllSubmissions(useCase);
    }
}

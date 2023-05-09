package com.tiklaisgelsin.api.domain.seeker.handler.submission;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SubmissionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSubmissionUseCaseHandler implements VoidUseCaseHandler<RemoveSubmission> {

    private final SubmissionPort submissionPort;

    @Override
    public void handle(RemoveSubmission useCase) {
        submissionPort.removeSubmission(useCase);
    }
}

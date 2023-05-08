package com.tiklaisgelsin.api.domain.seeker.handler.submission;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SubmissionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSubmissionUseCaseHandler implements UseCaseHandler<Void, RemoveSubmission> {

    private final SubmissionPort submissionPort;

    @Override
    public Void handle(RemoveSubmission useCase) {
        return submissionPort.removeSubmission(useCase);
    }
}

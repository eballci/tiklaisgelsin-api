package com.tiklaisgelsin.api.domain.seeker.handler.submission;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerSubmissionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveSubmissionUseCaseHandler implements VoidUseCaseHandler<RemoveSubmission> {

    private final SeekerSubmissionPort seekerSubmissionPort;

    @Override
    public void handle(RemoveSubmission useCase) {
        seekerSubmissionPort.removeSubmission(useCase);
    }
}

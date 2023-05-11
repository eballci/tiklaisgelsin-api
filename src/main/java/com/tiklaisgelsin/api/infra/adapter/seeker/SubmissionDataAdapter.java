package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.seeker.port.SubmissionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;
import com.tiklaisgelsin.api.infra.jpa.repository.SubmissionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionDataAdapter implements SubmissionPort {

    private final SubmissionJpaRepository repository;

    @Override
    public void removeSubmission(RemoveSubmission removeSubmission) {
        repository.deleteById(removeSubmission.getSubmissionId());
    }
}

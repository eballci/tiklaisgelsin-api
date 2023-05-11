package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.seeker.port.SeekerSubmissionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;
import com.tiklaisgelsin.api.infra.jpa.repository.SubmissionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeekerSubmissionDataAdapter implements SeekerSubmissionPort {

    private final SubmissionJpaRepository repository;

    @Override
    public void removeSubmission(RemoveSubmission removeSubmission) {
        repository.deleteById(removeSubmission.getSubmissionId());
    }
}

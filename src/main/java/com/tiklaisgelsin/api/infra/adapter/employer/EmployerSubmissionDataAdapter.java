package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.common.model.SubmissionStatus;
import com.tiklaisgelsin.api.domain.employer.port.EmployerSubmissionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.AcceptSubmission;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.ReadAllSubmissions;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.RefuseSubmission;
import com.tiklaisgelsin.api.infra.jpa.entity.SubmissionEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.SubmissionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerSubmissionDataAdapter implements EmployerSubmissionPort {

    private final SubmissionJpaRepository repository;

    @Override
    public void acceptSubmission(AcceptSubmission acceptSubmission) {
        Optional<SubmissionEntity> submission = repository.findById(acceptSubmission.getSubmissionId());

        if (submission.isEmpty()) return;

        submission.get().setStatus(SubmissionStatus.ACCEPTED.getLevel());
        repository.save(submission.get());
    }

    @Override
    public void readAllSubmissions(ReadAllSubmissions readAllSubmissions) {
        List<SubmissionEntity> submissionEntities = repository.findAllByEmployerId(readAllSubmissions.getEmployerId());
        submissionEntities
                .stream().filter(submissionEntity -> submissionEntity.getStatus() == 1)
                .forEach(submissionEntity -> {
                    submissionEntity.setStatus(SubmissionStatus.IDLE.getLevel());
                });
        repository.saveAll(submissionEntities);
    }

    @Override
    public void refuseSubmission(RefuseSubmission refuseSubmission) {
        Optional<SubmissionEntity> submission = repository.findById(refuseSubmission.getSubmissionId());

        if (submission.isEmpty()) return;

        submission.get().setStatus(SubmissionStatus.REFUSED.getLevel());
        repository.save(submission.get());
    }
}

package com.tiklaisgelsin.api.infra.rest.common.controller;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.AcceptSubmission;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.ReadAllSubmissions;
import com.tiklaisgelsin.api.domain.employer.usecase.submission.RefuseSubmission;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/submission/")
public class SubmissionController {

    private final VoidUseCaseHandler<AcceptSubmission> acceptSubmissionVoidUseCaseHandler;
    private final VoidUseCaseHandler<ReadAllSubmissions> allSubmissionsVoidUseCaseHandler;
    private final VoidUseCaseHandler<RefuseSubmission> refuseSubmissionVoidUseCaseHandler;
    private final VoidUseCaseHandler<RemoveSubmission> removeSubmissionVoidUseCaseHandler;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeSubmission(@PathVariable Long id) {
        removeSubmissionVoidUseCaseHandler.handle(RemoveSubmission.builder()
                .submissionId(id)
                .build());
    }

    @GetMapping("accept/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void acceptSubmission(@PathVariable Long id) {
        acceptSubmissionVoidUseCaseHandler.handle(AcceptSubmission.builder()
                .submissionId(id)
                .build());
    }

    @GetMapping("read/{employerId}")
    @ResponseStatus(HttpStatus.OK)
    public void readAllSubmissions(@PathVariable Long employerId) {
        allSubmissionsVoidUseCaseHandler.handle(ReadAllSubmissions.builder()
                .employerId(employerId)
                .build());
    }

    @GetMapping("refuse/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void refuseSubmission(@PathVariable Long id) {
        refuseSubmissionVoidUseCaseHandler.handle(RefuseSubmission.builder()
                .submissionId(id)
                .build());
    }

}

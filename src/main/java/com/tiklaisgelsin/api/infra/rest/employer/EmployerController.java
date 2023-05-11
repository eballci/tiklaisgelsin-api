package com.tiklaisgelsin.api.infra.rest.employer;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerCreate;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerGet;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerUpdate;
import com.tiklaisgelsin.api.infra.rest.employer.dto.employer.EmployerCreateRequest;
import com.tiklaisgelsin.api.infra.rest.employer.dto.employer.EmployerForVisitResponse;
import com.tiklaisgelsin.api.infra.rest.employer.dto.employer.EmployerUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employer/")
public class EmployerController {

    private final UseCaseHandler<Employer, EmployerGet> getUseCaseHandler;
    private final UseCaseHandler<Employer, EmployerCreate> createUseCaseHandler;
    private final VoidUseCaseHandler<EmployerUpdate> updateUseCaseHandler;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployerForVisitResponse getEmployerForVisit(@PathVariable Long id) {
        return EmployerForVisitResponse.fromModel(
                getUseCaseHandler.handle(
                        EmployerGet.builder()
                                .employerId(id)
                                .build()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployerForVisitResponse createEmployer(@Validated @RequestBody EmployerCreateRequest request) {
        return EmployerForVisitResponse.fromModel(
                createUseCaseHandler.handle(
                        EmployerCreate.builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .password(request.getPassword())
                                .build()));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployer(@Validated @RequestBody EmployerUpdateRequest request) {
        updateUseCaseHandler.handle(
                EmployerUpdate.builder()
                        .employerId(request.getId())
                        .name(request.getName())
                        .description(request.getDescription())
                        .email(request.getEmail())
                        .webSite(request.getWebSite())
                        .scale(request.getScale())
                        .build());
    }
}

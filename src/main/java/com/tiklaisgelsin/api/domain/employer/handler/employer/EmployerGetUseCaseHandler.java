package com.tiklaisgelsin.api.domain.employer.handler.employer;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerPort;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerGet;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployerGetUseCaseHandler implements UseCaseHandler<Employer, EmployerGet> {

    private final EmployerPort employerPort;

    @Override
    public Employer handle(EmployerGet useCase) {
        return employerPort.getEmployer(useCase);
    }
}

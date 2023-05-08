package com.tiklaisgelsin.api.domain.employer.handler.employer;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerPort;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerUpdate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployerUpdateUseCaseHandler implements UseCaseHandler<Void, EmployerUpdate> {

    private final EmployerPort employerPort;

    @Override
    public Void handle(EmployerUpdate useCase) {
        return employerPort.updateEmployer(useCase);
    }
}

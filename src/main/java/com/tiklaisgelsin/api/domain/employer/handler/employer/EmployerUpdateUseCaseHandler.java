package com.tiklaisgelsin.api.domain.employer.handler.employer;

import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerPort;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerUpdateUseCaseHandler implements VoidUseCaseHandler<EmployerUpdate> {

    private final EmployerPort employerPort;

    @Override
    public void handle(EmployerUpdate useCase) {
        employerPort.updateEmployer(useCase);
    }
}

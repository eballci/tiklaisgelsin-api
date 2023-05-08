package com.tiklaisgelsin.api.domain.employer.handler.employer;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.port.EmployerPort;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerCreateUseCaseHandler implements UseCaseHandler<Employer, EmployerCreate> {

    private final EmployerPort employerPort;

    @Override
    public Employer handle(EmployerCreate useCase) {
        return employerPort.createEmployer(useCase);
    }
}

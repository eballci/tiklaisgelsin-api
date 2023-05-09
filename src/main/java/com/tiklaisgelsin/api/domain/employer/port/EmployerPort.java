package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerCreate;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerGet;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerUpdate;

public interface EmployerPort {
    Employer getEmployer(EmployerGet employerGet);

    Employer createEmployer(EmployerCreate employerCreate);

    void updateEmployer(EmployerUpdate employerUpdate);
}

package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import com.tiklaisgelsin.api.domain.employer.port.EmployerPort;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerCreate;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerGet;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerUpdate;
import com.tiklaisgelsin.api.infra.jpa.entity.EmployerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EmployerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerDataAdapter implements EmployerPort {

    private final EmployerJpaRepository repository;

    @Override
    public Employer getEmployer(EmployerGet employerGet) {
        return repository.findById(employerGet.getEmployerId())
                .map(EmployerEntity::toModel)
                .orElse(null);
    }

    @Override
    public Employer createEmployer(EmployerCreate employerCreate) {
        EmployerEntity employer = new EmployerEntity();
        employer.setName(employerCreate.getName());
        employer.setEmail(employerCreate.getEmail());
        employer.setPassword(employerCreate.getPassword());

        return repository.save(employer).toModel();
    }

    @Override
    public void updateEmployer(EmployerUpdate employerUpdate) {
        Optional<EmployerEntity> employer = repository.findById(employerUpdate.getEmployerId());

        if (employer.isEmpty()) return;

        employer.get().setName(employerUpdate.getName());
        employer.get().setDescription(employerUpdate.getDescription());
        employer.get().setEmail(employerUpdate.getEmail());
        employer.get().setScale(employerUpdate.getScale());
        employer.get().setWebSite(employerUpdate.getWebSite());

        repository.save(employer.get());
    }

    @Override
    public boolean checkIfEmployerExists(String email) {
        return repository.findByEmail(email).isPresent();
    }
}

package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.employer.port.EmployerAvatarPort;
import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import com.tiklaisgelsin.api.infra.jpa.entity.EmployerAvatarEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.EmployerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EmployerAvatarJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.EmployerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerAvatarDataAdapter implements EmployerAvatarPort {

    private final EmployerJpaRepository employerJpaRepository;
    private final EmployerAvatarJpaRepository repository;

    @Override
    public void updateSeekerAvatar(UpdateEmployerAvatar updateEmployerAvatar) {
        Optional<EmployerAvatarEntity> avatar = repository.findById(updateEmployerAvatar.getEmployerId());

        if (avatar.isEmpty()) {
            Optional<EmployerEntity> employer = employerJpaRepository.findById(updateEmployerAvatar.getEmployerId());

            if (employer.isEmpty()) return;

            EmployerAvatarEntity newAvatar = new EmployerAvatarEntity();

            newAvatar.setEmployer(employer.get());
            newAvatar.setFile(updateEmployerAvatar.getAvatar());

            repository.save(newAvatar);
        } else {
            avatar.get().setFile(updateEmployerAvatar.getAvatar());
            repository.save(avatar.get());
        }
    }
}

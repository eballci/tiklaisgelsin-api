package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.employer.port.AvatarPort;
import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import com.tiklaisgelsin.api.infra.jpa.entity.EmployerAvatarEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EmployerAvatarJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvatarDataAdapter implements AvatarPort {

    private final EmployerAvatarJpaRepository repository;

    @Override
    public void updateSeekerAvatar(UpdateEmployerAvatar updateEmployerAvatar) {
        Optional<EmployerAvatarEntity> avatar = repository.findById(updateEmployerAvatar.getEmployerId());

        if (avatar.isEmpty()) return;

        avatar.get().setFile(updateEmployerAvatar.getAvatar());
        repository.save(avatar.get());
    }
}

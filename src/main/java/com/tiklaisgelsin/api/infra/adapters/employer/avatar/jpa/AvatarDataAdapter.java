package com.tiklaisgelsin.api.infra.adapters.employer.avatar.jpa;

import com.tiklaisgelsin.api.domain.employer.port.AvatarPort;
import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import com.tiklaisgelsin.api.infra.adapters.employer.avatar.jpa.entity.AvatarEntity;
import com.tiklaisgelsin.api.infra.adapters.employer.avatar.jpa.repository.AvatarJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvatarDataAdapter implements AvatarPort {

    private final AvatarJpaRepository repository;

    @Override
    public Void updateSeekerAvatar(UpdateEmployerAvatar updateEmployerAvatar) {
        AvatarEntity entity = repository.findByEmployerId(updateEmployerAvatar.getEmployerId());

        if (entity == null) {
            entity = new AvatarEntity();
            entity.setEmployerId(updateEmployerAvatar.getEmployerId());
        }

        entity.setAvatar(updateEmployerAvatar.getAvatar());
        repository.save(entity);
        return null;
    }
}

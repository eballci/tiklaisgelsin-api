package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.seeker.port.SeekerAvatarPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.avatar.UpdateSeekerAvatar;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerAvatarEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerAvatarJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeekerAvatarDataAdapter implements SeekerAvatarPort {

    private final SeekerJpaRepository seekerJpaRepository;
    private final SeekerAvatarJpaRepository repository;

    @Override
    public void updateAvatar(UpdateSeekerAvatar updateSeekerAvatar) {
        Optional<SeekerAvatarEntity> avatar = repository.findById(updateSeekerAvatar.getSeekerId());

        if (avatar.isEmpty()) {
            Optional<SeekerEntity> seeker = seekerJpaRepository.findById(updateSeekerAvatar.getSeekerId());

            if (seeker.isEmpty()) return;

            SeekerAvatarEntity newAvatar = new SeekerAvatarEntity();

            newAvatar.setSeeker(seeker.get());
            newAvatar.setFile(updateSeekerAvatar.getAvatar());

            repository.save(newAvatar);
        } else {
            avatar.get().setFile(updateSeekerAvatar.getAvatar());
            repository.save(avatar.get());
        }
    }
}

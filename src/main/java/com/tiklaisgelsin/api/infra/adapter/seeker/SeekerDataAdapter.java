package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerCreate;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerGet;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeekerDataAdapter implements SeekerPort {

    private final SeekerJpaRepository repository;

    @Override
    public Seeker getSeeker(SeekerGet getSeeker) {
        return repository.findById(getSeeker.getSeekerId())
                .map(SeekerEntity::toModel)
                .orElse(null);
    }

    @Override
    public Seeker createSeeker(SeekerCreate seekerCreate) {
        SeekerEntity seeker = new SeekerEntity();
        seeker.setName(seekerCreate.getName());
        seeker.setSurname(seekerCreate.getSurname());
        seeker.setEmail(seekerCreate.getEmail());
        seeker.setBirth(seekerCreate.getBirth());
        seeker.setPassword(seekerCreate.getPassword());
        return repository.save(seeker).toModel();
    }

    @Override
    public void updateSeeker(SeekerUpdate seekerUpdate) {
        Optional<SeekerEntity> seeker = repository
                .findById(seekerUpdate.getSeekerId());

        if (seeker.isEmpty()) return;

        seeker.get().setName(seekerUpdate.getName());
        seeker.get().setSurname(seekerUpdate.getSurname());
        seeker.get().setEmail(seekerUpdate.getEmail());
        seeker.get().setBiography(seekerUpdate.getBiography());
        seeker.get().setBirth(seekerUpdate.getBirth());
        repository.save(seeker.get());
    }

    @Override
    public List<Seeker> getAllSeekers() {
        return repository.findAll().stream()
                .map(SeekerEntity::toModel)
                .toList();
    }

    @Override
    public boolean checkIfSeekerAlreadyExists(String email) {
        return repository.findByEmail(email).isPresent();
    }
}

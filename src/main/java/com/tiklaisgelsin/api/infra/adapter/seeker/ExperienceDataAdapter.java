package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Experience;
import com.tiklaisgelsin.api.domain.seeker.port.ExperiencePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.AddSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.RemoveSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.UpdateSeekerExperience;
import com.tiklaisgelsin.api.infra.jpa.entity.ExperienceEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.ExperienceJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceDataAdapter implements ExperiencePort {

    private final SeekerJpaRepository seekerJpaRepository;
    private final ExperienceJpaRepository experienceJpaRepository;

    @Override
    public Experience addExperience(AddSeekerExperience addSeekerExperience) {
        Optional<SeekerEntity> seeker = seekerJpaRepository
                .findById(addSeekerExperience.getSeekerId());

        if (seeker.isEmpty()) return null;

        ExperienceEntity experience = new ExperienceEntity();
        experience.setSeeker(seeker.get());
        experience.setCompany(addSeekerExperience.getCompany());
        experience.setDepartment(addSeekerExperience.getDepartment());
        experience.setPosition(addSeekerExperience.getPosition());
        experience.setDescription(addSeekerExperience.getDescription());
        experience.setStart(addSeekerExperience.getStart());
        experience.setCompletion(addSeekerExperience.getEnd());
        return experienceJpaRepository.save(experience).toModel();
    }

    @Override
    public void updateExperience(UpdateSeekerExperience updateSeekerExperience) {
        Optional<ExperienceEntity> experience = experienceJpaRepository
                .findById(updateSeekerExperience.getExperienceId());

        if (experience.isEmpty()) return;

        experience.get().setCompany(updateSeekerExperience.getCompany());
        experience.get().setDepartment(updateSeekerExperience.getDepartment());
        experience.get().setPosition(updateSeekerExperience.getPosition());
        experience.get().setDescription(updateSeekerExperience.getDescription());
        experience.get().setStart(updateSeekerExperience.getStart());
        experience.get().setCompletion(updateSeekerExperience.getEnd());
        experienceJpaRepository.save(experience.get());
    }

    @Override
    public void removeExperience(RemoveSeekerExperience removeSeekerExperience) {
        experienceJpaRepository.deleteById(removeSeekerExperience.getExperienceId());
    }
}

package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.seeker.port.EducationPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.AddSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.RemoveSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.UpdateSeekerEducation;
import com.tiklaisgelsin.api.infra.jpa.entity.EducationEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EducationJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationDataAdapter implements EducationPort {

    private final SeekerJpaRepository seekerJpaRepository;
    private final EducationJpaRepository educationJpaRepository;

    @Override
    public Education createEducation(AddSeekerEducation useCase) {
        Optional<SeekerEntity> seeker = seekerJpaRepository.findById(useCase.getSeekerId());

        if (seeker.isEmpty()) return null;

        EducationEntity education = new EducationEntity();
        education.setStudy(useCase.getStudy());
        education.setInstitution(useCase.getInstitution());
        education.setDescription(useCase.getDescription());
        education.setStart(useCase.getStart());
        education.setEnd(useCase.getEnd());
        education.setGPA(useCase.getGPA());
        education.setLevel(useCase.getLevel());
        education.setSeeker(seeker.get());

        return educationJpaRepository.save(education).toModel();
    }

    @Override
    public void updateEducation(UpdateSeekerEducation useCase) {
        Optional<EducationEntity> education = educationJpaRepository.findById(useCase.getEducationId());

        if (education.isEmpty()) return;

        education.get().setStudy(useCase.getStudy());
        education.get().setInstitution(useCase.getInstitution());
        education.get().setDescription(useCase.getDescription());
        education.get().setStart(useCase.getStart());
        education.get().setEnd(useCase.getEnd());
        education.get().setGPA(useCase.getGPA());
        education.get().setLevel(useCase.getLevel());

        educationJpaRepository.save(education.get());
    }

    @Override
    public void removeEducation(RemoveSeekerEducation useCase) {
        educationJpaRepository.deleteById(useCase.getEducationId());
    }
}

package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.CreatePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.DeletePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.UpdatePosition;
import com.tiklaisgelsin.api.infra.jpa.entity.*;
import com.tiklaisgelsin.api.infra.jpa.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionDataAdapter implements PositionPort {

    private final EmployerJpaRepository employerJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final LanguageCriteriaJpaRepository languageCriteriaJpaRepository;
    private final EducationCriteriaJpaRepository educationCriteriaJpaRepository;
    private final ExperienceCriteriaJpaRepository experienceCriteriaJpaRepository;

    @Override
    public Position getPosition(Long id) {
        return positionJpaRepository.findById(id)
                .map(PositionEntity::toModel)
                .orElse(null);
    }

    @Override
    public Position createPosition(CreatePosition createPosition) {
        Optional<EmployerEntity> employer = employerJpaRepository.findById(createPosition.getEmployerId());

        if (employer.isEmpty()) return null;

        PositionEntity position = new PositionEntity();

        position.setTitle(createPosition.getTitle());
        position.setDescription(createPosition.getDescription());
        position.setEmployer(employer.get());

        if (createPosition.getEducationCriteria() != null) {
            EducationCriteriaEntity educationCriteria = new EducationCriteriaEntity();
            educationCriteria.setPosition(position);
            educationCriteria.setStudy(createPosition.getEducationCriteria().getStudy());
            educationCriteria.setExpectedLevel(createPosition.getEducationCriteria().getMinEducationLevel().getLevel());
            position.setEducationCriteria(educationCriteria);
        }

        if (createPosition.getExperienceCriteria() != null) {
            ExperienceCriteriaEntity experienceCriteria = new ExperienceCriteriaEntity();
            experienceCriteria.setPosition(position);
            experienceCriteria.setContent(
                    String.join(",", createPosition.getExperienceCriteria().getTitles())
            );
            experienceCriteria.setExpectation(createPosition.getExperienceCriteria().getMinimumYears());
            position.setExperienceCriteria(experienceCriteria);
        }

        createPosition.getLanguageCriteriaList().forEach(lc -> {
            LanguageCriteriaEntity languageCriteria = new LanguageCriteriaEntity();
            languageCriteria.setPosition(position);
            languageCriteria.setLanguage(lc.getExpectedLanguage());
            languageCriteria.setExpectedLevel(lc.getExpectedLevel().getLevel());
            position.getLanguageCriterias().add(languageCriteria);
        });

        return positionJpaRepository.save(position).toModel();
    }

    @Override
    public void updatePosition(UpdatePosition updatePosition) {
        Optional<PositionEntity> position = positionJpaRepository.findById(updatePosition.getPositionId());

        if (position.isEmpty()) return;

        languageCriteriaJpaRepository.deleteAllByPositionId(updatePosition.getPositionId());
        educationCriteriaJpaRepository.deleteByPositionId(updatePosition.getPositionId());
        experienceCriteriaJpaRepository.deleteByPositionId(updatePosition.getPositionId());

        position.get().setTitle(updatePosition.getTitle());
        position.get().setDescription(updatePosition.getDescription());

        if (updatePosition.getEducationCriteria() != null) {
            EducationCriteriaEntity educationCriteria = new EducationCriteriaEntity();
            educationCriteria.setPosition(position.get());
            educationCriteria.setStudy(updatePosition.getEducationCriteria().getStudy());
            educationCriteria.setExpectedLevel(updatePosition.getEducationCriteria().getMinEducationLevel().getLevel());
            position.get().setEducationCriteria(educationCriteria);
        }

        if (updatePosition.getExperienceCriteria() != null) {
            ExperienceCriteriaEntity experienceCriteria = new ExperienceCriteriaEntity();
            experienceCriteria.setPosition(position.get());
            experienceCriteria.setContent(
                    String.join(",", updatePosition.getExperienceCriteria().getTitles())
            );
            experienceCriteria.setExpectation(updatePosition.getExperienceCriteria().getMinimumYears());
            position.get().setExperienceCriteria(experienceCriteria);
        }

        updatePosition.getLanguageCriteriaList().forEach(lc -> {
            LanguageCriteriaEntity languageCriteria = new LanguageCriteriaEntity();
            languageCriteria.setPosition(position.get());
            languageCriteria.setLanguage(lc.getExpectedLanguage());
            languageCriteria.setExpectedLevel(lc.getExpectedLevel().getLevel());
            position.get().getLanguageCriterias().add(languageCriteria);
        });

        positionJpaRepository.save(position.get());
    }

    @Override
    public void removePosition(DeletePosition deletePosition) {
        positionJpaRepository.deleteById(deletePosition.getPositionId());
    }

    @Override
    public List<Position> getAllPositions() {
        return positionJpaRepository.findAll().stream()
                .map(PositionEntity::toModel)
                .toList();
    }

    @Override
    public boolean checkIfPositionDoesntExist(Long id) {
        return positionJpaRepository.findById(id).isEmpty();
    }
}

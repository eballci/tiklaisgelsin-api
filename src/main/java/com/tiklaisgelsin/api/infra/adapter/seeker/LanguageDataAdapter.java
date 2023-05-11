package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Language;
import com.tiklaisgelsin.api.domain.seeker.port.LanguagePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.AddSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.RemoveSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;
import com.tiklaisgelsin.api.infra.jpa.entity.LanguageEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.LanguageJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageDataAdapter implements LanguagePort {

    private final SeekerJpaRepository seekerJpaRepository;
    private final LanguageJpaRepository languageJpaRepository;

    @Override
    public Language addLanguage(AddSeekerLanguage addSeekerLanguage) {
        Optional<SeekerEntity> seeker = seekerJpaRepository.findById(addSeekerLanguage.getSeekerId());

        if (seeker.isEmpty()) return null;

        LanguageEntity language = new LanguageEntity();
        language.setLanguage(addSeekerLanguage.getName());
        language.setLevel(addSeekerLanguage.getLevel());
        language.setSeeker(seeker.get());
        return languageJpaRepository.save(language).toModel();
    }

    @Override
    public void updateLanguage(UpdateSeekerLanguage updateSeekerLanguage) {
        Optional<LanguageEntity> language = languageJpaRepository.findById(updateSeekerLanguage.getEntityId());

        if (language.isEmpty()) return;

        language.get().setLanguage(updateSeekerLanguage.getLanguage());
        language.get().setLevel(updateSeekerLanguage.getLevel());
        languageJpaRepository.save(language.get());
    }

    @Override
    public void removeLanguage(RemoveSeekerLanguage removeSeekerLanguage) {
        languageJpaRepository.deleteById(removeSeekerLanguage.getLanguageId());
    }
}

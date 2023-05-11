package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Submission;
import com.tiklaisgelsin.api.domain.common.model.SubmissionStatus;
import com.tiklaisgelsin.api.domain.seeker.port.SeekerSuggestionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.IgnorePositionSuggestion;
import com.tiklaisgelsin.api.domain.seeker.usecase.suggestion.SubmitSuggestion;
import com.tiklaisgelsin.api.infra.jpa.entity.SubmissionEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SuggestionEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.SubmissionJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SuggestionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeekerSuggestionDataAdapter implements SeekerSuggestionPort {

    private final SubmissionJpaRepository submissionJpaRepository;
    private final SuggestionJpaRepository suggestionJpaRepository;

    @Override
    public Submission submitSuggestion(SubmitSuggestion submitSuggestion) {
        Optional<SuggestionEntity> suggestion = suggestionJpaRepository
                .findById(submitSuggestion.getSuggestionId());

        if (suggestion.isEmpty()) return null;

        SubmissionEntity submission = new SubmissionEntity();
        submission.setStatus(SubmissionStatus.ISSUED.getLevel());
        submission.setEmployer(suggestion.get().getEmployer());
        submission.setPosition(suggestion.get().getPosition());
        submission.setEmployer(suggestion.get().getEmployer());
        return submissionJpaRepository.save(submission).toModel();
    }

    @Override
    public void ignorePositionSuggestion(IgnorePositionSuggestion ignorePositionSuggestion) {
        suggestionJpaRepository.deleteById(ignorePositionSuggestion.getSuggestionId());
    }
}

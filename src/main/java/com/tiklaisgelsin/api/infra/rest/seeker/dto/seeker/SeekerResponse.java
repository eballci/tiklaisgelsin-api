package com.tiklaisgelsin.api.infra.rest.seeker.dto.seeker;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.infra.rest.common.dto.OfferResponse;
import com.tiklaisgelsin.api.infra.rest.common.dto.SubmissionResponse;
import com.tiklaisgelsin.api.infra.rest.common.dto.SuggestionResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.education.EducationResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.experience.ExperienceResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.language.LanguageResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.phone.PhoneResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeekerResponse {
    private Long id;
    private String name;
    private String surname;
    private String avatar;
    private String email;
    private String biography;
    private LocalDate birth;
    private List<PhoneResponse> phones;
    private List<LanguageResponse> languages;
    private List<ExperienceResponse> experiences;
    private List<EducationResponse> educations;
    private List<SubmissionResponse> submissions;
    private List<OfferResponse> offers;
    private SortedSet<SuggestionResponse> suggestions;

    public static SeekerResponse fromModel(Seeker seeker) {
        return SeekerResponse.builder()
                .id(seeker.getId())
                .name(seeker.getName())
                .surname(seeker.getSurname())
                .avatar(seeker.getAvatar())
                .email(seeker.getEmail())
                .biography(seeker.getBiography())
                .birth(seeker.getBirth())
                .languages(seeker.getLanguages().stream().map(LanguageResponse::fromModel).toList())
                .phones(seeker.getPhones().stream().map(PhoneResponse::fromModel).toList())
                .experiences(seeker.getExperiences().stream().map(ExperienceResponse::fromModel).toList())
                .educations(seeker.getEducations().stream().map(EducationResponse::fromModel).toList())
                .submissions(seeker.getSubmissions().stream().map(SubmissionResponse::fromModel).toList())
                .offers(seeker.getOffers().stream().map(OfferResponse::fromModel).toList())
                .suggestions(
                        seeker.getPositionSuggestions().stream()
                                .map(SuggestionResponse::fromModel)
                                .collect(Collectors.toCollection(TreeSet::new))
                )
                .build();
    }

}

package com.tiklaisgelsin.api.infra.rest.seeker.dto.seeker;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.education.EducationResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.experience.ExperienceResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.language.LanguageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeekerForVisitResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String avatar;
    private String biography;
    private List<LanguageResponse> languages;
    private List<ExperienceResponse> experiences;
    private List<EducationResponse> educations;

    public static SeekerForVisitResponse fromModel(Seeker seeker) {
        return SeekerForVisitResponse.builder()
                .id(seeker.getId())
                .name(seeker.getName())
                .surname(seeker.getSurname())
                .email(seeker.getEmail())
                .avatar(seeker.getAvatar())
                .biography(seeker.getBiography())
                .languages(seeker.getLanguages().stream().map(LanguageResponse::fromModel).toList())
                .experiences(seeker.getExperiences().stream().map(ExperienceResponse::fromModel).toList())
                .educations(seeker.getEducations().stream().map(EducationResponse::fromModel).toList())
                .build();
    }
}

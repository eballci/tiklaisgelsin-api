package com.tiklaisgelsin.api.infra.rest.seeker.dto.education;

import com.tiklaisgelsin.api.domain.common.model.Education;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationResponse {
    private Long id;
    private String study;
    private String institution;
    private String description;
    private float GPA;
    private LocalDate start;
    private LocalDate end;
    private int educationLevel;

    public static EducationResponse fromModel(Education education) {
        return EducationResponse.builder()
                .id(education.getId())
                .study(education.getStudy())
                .institution(education.getInstitution())
                .description(education.getDescription())
                .GPA(education.getGPA())
                .start(education.getStart())
                .end(education.getEnd())
                .educationLevel(education.getEducationLevel().getLevel())
                .build();
    }
}

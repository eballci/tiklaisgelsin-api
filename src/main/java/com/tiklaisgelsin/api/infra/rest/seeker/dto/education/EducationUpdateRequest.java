package com.tiklaisgelsin.api.infra.rest.seeker.dto.education;

import com.tiklaisgelsin.api.domain.seeker.usecase.education.UpdateSeekerEducation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationUpdateRequest {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String study;

    @NotNull
    @NotBlank
    private String institution;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private float GPA;

    @NotNull
    private LocalDate start;

    private LocalDate end;

    @NotNull
    private int educationLevel;

    public UpdateSeekerEducation toUseCase() {
        return UpdateSeekerEducation.builder()
                .educationId(id)
                .study(study)
                .institution(institution)
                .description(description)
                .GPA(GPA)
                .start(start)
                .end(end)
                .level(educationLevel)
                .build();
    }

}

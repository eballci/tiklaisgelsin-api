package com.tiklaisgelsin.api.infra.rest.seeker.dto.experience;

import com.tiklaisgelsin.api.domain.seeker.usecase.experience.UpdateSeekerExperience;
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
public class ExperienceUpdateRequest {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String company;

    @NotNull
    @NotBlank
    private String department;

    @NotNull
    @NotBlank
    private String position;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private LocalDate start;

    private LocalDate end;

    public UpdateSeekerExperience toUseCase() {
        return UpdateSeekerExperience.builder()
                .experienceId(id)
                .company(company)
                .department(department)
                .position(position)
                .description(description)
                .start(start)
                .end(end)
                .build();
    }
}

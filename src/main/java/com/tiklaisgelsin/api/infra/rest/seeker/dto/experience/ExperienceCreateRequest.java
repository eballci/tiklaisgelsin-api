package com.tiklaisgelsin.api.infra.rest.seeker.dto.experience;

import com.tiklaisgelsin.api.domain.seeker.usecase.experience.AddSeekerExperience;
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
public class ExperienceCreateRequest {

    @NotNull
    private Long seekerId;

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

    public AddSeekerExperience toUseCase() {
        return AddSeekerExperience.builder()
                .seekerId(seekerId)
                .company(company)
                .department(department)
                .position(position)
                .description(description)
                .start(start)
                .end(end)
                .build();
    }
}

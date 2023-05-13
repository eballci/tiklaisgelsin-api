package com.tiklaisgelsin.api.infra.rest.seeker.dto.experience;

import com.tiklaisgelsin.api.domain.common.model.Experience;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResponse {
    private Long id;
    private String company;
    private String department;
    private String position;
    private String description;
    private LocalDate start;
    private LocalDate end;

    public static ExperienceResponse fromModel(Experience experience) {
        return ExperienceResponse.builder()
                .id(experience.getId())
                .company(experience.getCompany())
                .department(experience.getDepartment())
                .position(experience.getPosition())
                .description(experience.getDescription())
                .start(experience.getStart())
                .end(experience.getEnd())
                .build();
    }
}

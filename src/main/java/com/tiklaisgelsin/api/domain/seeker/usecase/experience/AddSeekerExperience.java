package com.tiklaisgelsin.api.domain.seeker.usecase.experience;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AddSeekerExperience implements UseCase {
    private Long seekerId;
    private String company;
    private String department;
    private String position;
    private String description;
    private LocalDate start;
    private LocalDate end;
}

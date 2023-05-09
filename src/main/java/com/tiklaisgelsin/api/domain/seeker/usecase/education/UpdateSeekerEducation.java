package com.tiklaisgelsin.api.domain.seeker.usecase.education;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UpdateSeekerEducation implements UseCase {
    private Long seekerId;
    private String study;
    private String institution;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private float GPA;
    private int level;
}

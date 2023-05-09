package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Education {
    private Long id;
    private String study;
    private String institution;
    private String description;
    private float GPA;
    private LocalDate start;
    private LocalDate end;
    private EducationLevel educationLevel;
}

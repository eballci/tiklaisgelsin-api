package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Experience {
    private Long id;
    private String company;
    private String department;
    private String position;
    private String description;
    private LocalDate start;
    private LocalDate end;
}

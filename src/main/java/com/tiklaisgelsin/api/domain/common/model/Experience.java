package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    public long getMonthsEmployed() {
        return ChronoUnit.MONTHS.between(start.withDayOfMonth(1), end.withDayOfMonth(1));
    }
}

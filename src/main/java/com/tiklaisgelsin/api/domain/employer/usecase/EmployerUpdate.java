package com.tiklaisgelsin.api.domain.employer.usecase;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployerUpdate {
    private Long employerId;
    private String name;
    private String description;
    private String email;
    private int scale;
    private String webSite;
}

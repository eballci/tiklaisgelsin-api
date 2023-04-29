package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    private Long id;
    private Employer employer;
    private String title;
    private String description;
}

package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Employer {
    private Long id;
    private String avatar;
    private String name;
    private String description;
    private String email;
    private int scale;
    private String webSite;
    private List<Position> openPositions;
    private List<Submission> submissions;
    private List<SeekerSuggestion> seekerSuggestions;
}

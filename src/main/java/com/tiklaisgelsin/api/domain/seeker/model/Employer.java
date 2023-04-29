package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employer {
    private Long id;
    private String avatar;
    private String name;
}

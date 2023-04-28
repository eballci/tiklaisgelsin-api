package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {
    private Long id;
    private String prefix;
    private String number;
}

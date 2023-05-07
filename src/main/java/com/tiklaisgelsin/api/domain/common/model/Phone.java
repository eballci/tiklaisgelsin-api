package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {
    private Long id;
    private String prefix;
    private String number;
}

package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Language {
    private Long id;
    private String name;
    private LanguageLevel level;
}

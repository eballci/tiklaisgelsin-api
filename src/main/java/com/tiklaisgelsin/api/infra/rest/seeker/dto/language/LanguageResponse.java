package com.tiklaisgelsin.api.infra.rest.seeker.dto.language;

import com.tiklaisgelsin.api.domain.common.model.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponse {
    private Long id;
    private String language;
    private int level;

    public static LanguageResponse fromModel(Language language) {
        return LanguageResponse.builder()
                .id(language.getId())
                .language(language.getName())
                .level(language.getLevel().getLevel())
                .build();
    }
}

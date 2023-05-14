package com.tiklaisgelsin.api.infra.rest.seeker.dto.language;

import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageUpdateRequest {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String language;

    @NotNull
    private int level;

    public UpdateSeekerLanguage toUseCase() {
        return UpdateSeekerLanguage.builder()
                .entityId(id)
                .language(language)
                .level(level)
                .build();
    }

}

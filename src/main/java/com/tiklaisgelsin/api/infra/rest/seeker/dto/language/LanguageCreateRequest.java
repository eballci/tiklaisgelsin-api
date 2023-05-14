package com.tiklaisgelsin.api.infra.rest.seeker.dto.language;

import com.tiklaisgelsin.api.domain.seeker.usecase.language.AddSeekerLanguage;
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
public class LanguageCreateRequest {

    @NotNull
    private Long seekerId;

    @NotNull
    @NotBlank
    private String language;

    @NotNull
    private int level;

    public AddSeekerLanguage toUseCase() {
        return AddSeekerLanguage.builder()
                .seekerId(seekerId)
                .name(language)
                .level(level)
                .build();
    }

}

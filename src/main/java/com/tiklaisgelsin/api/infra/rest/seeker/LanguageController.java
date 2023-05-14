package com.tiklaisgelsin.api.infra.rest.seeker;

import com.tiklaisgelsin.api.domain.common.model.Language;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.AddSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.RemoveSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.language.LanguageCreateRequest;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.language.LanguageResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.language.LanguageUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/language/")
public class LanguageController {

    private final UseCaseHandler<Language, AddSeekerLanguage> addHandler;
    private final VoidUseCaseHandler<UpdateSeekerLanguage> updateHandler;
    private final VoidUseCaseHandler<RemoveSeekerLanguage> removeHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LanguageResponse createEducation(@Validated @RequestBody LanguageCreateRequest request) {
        return LanguageResponse.fromModel(addHandler.handle(request.toUseCase()));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEducation(@Validated @RequestBody LanguageUpdateRequest request) {
        updateHandler.handle(request.toUseCase());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEducation(@PathVariable Long id) {
        removeHandler.handle(RemoveSeekerLanguage.builder()
                .languageId(id)
                .build());
    }

}

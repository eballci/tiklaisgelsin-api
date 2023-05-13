package com.tiklaisgelsin.api.infra.rest.seeker;

import com.tiklaisgelsin.api.domain.common.model.Experience;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.AddSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.RemoveSeekerExperience;
import com.tiklaisgelsin.api.domain.seeker.usecase.experience.UpdateSeekerExperience;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.experience.ExperienceCreateRequest;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.experience.ExperienceResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.experience.ExperienceUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/experience/")
public class ExperienceController {

    private final UseCaseHandler<Experience, AddSeekerExperience> addHandler;
    private final VoidUseCaseHandler<RemoveSeekerExperience> removeHandler;
    private final VoidUseCaseHandler<UpdateSeekerExperience> updateHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExperienceResponse createEducation(@Validated @RequestBody ExperienceCreateRequest request) {
        return ExperienceResponse.fromModel(addHandler.handle(request.toUseCase()));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEducation(@Validated @RequestBody ExperienceUpdateRequest request) {
        updateHandler.handle(request.toUseCase());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEducation(@PathVariable Long id) {
        removeHandler.handle(RemoveSeekerExperience.builder()
                .experienceId(id)
                .build());
    }

}

package com.tiklaisgelsin.api.infra.rest.seeker;

import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.AddSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.RemoveSeekerEducation;
import com.tiklaisgelsin.api.domain.seeker.usecase.education.UpdateSeekerEducation;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.education.EducationCreateRequest;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.education.EducationResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.education.EducationUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/education/")
public class EducationController {

    private final UseCaseHandler<Education, AddSeekerEducation> addHandler;
    private final VoidUseCaseHandler<RemoveSeekerEducation> removeHandler;
    private final VoidUseCaseHandler<UpdateSeekerEducation> updateHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EducationResponse createEducation(@Validated @RequestBody EducationCreateRequest request) {
        return EducationResponse.fromModel(addHandler.handle(request.toUseCase()));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEducation(@Validated @RequestBody EducationUpdateRequest request) {
        updateHandler.handle(request.toUseCase());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEducation(@PathVariable Long id) {
        removeHandler.handle(RemoveSeekerEducation.builder()
                .educationId(id)
                .build());
    }

}

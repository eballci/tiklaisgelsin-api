package com.tiklaisgelsin.api.infra.rest.seeker;

import com.tiklaisgelsin.api.domain.common.model.Phone;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.AddSeekerPhone;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.RemoveSeekerPhone;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.UpdateSeekerPhone;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.phone.CreatePhoneRequest;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.phone.PhoneResponse;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.phone.UpdatePhoneRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phone/")
public class PhoneController {

    private final UseCaseHandler<Phone, AddSeekerPhone> addHandler;
    private final VoidUseCaseHandler<UpdateSeekerPhone> updateHandler;
    private final VoidUseCaseHandler<RemoveSeekerPhone> removeHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneResponse createEducation(@Validated @RequestBody CreatePhoneRequest request) {
        return PhoneResponse.fromModel(addHandler.handle(request.toUseCase()));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEducation(@Validated @RequestBody UpdatePhoneRequest request) {
        updateHandler.handle(request.toUseCase());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEducation(@PathVariable Long id) {
        removeHandler.handle(RemoveSeekerPhone.builder()
                .phoneId(id)
                .build());
    }

}

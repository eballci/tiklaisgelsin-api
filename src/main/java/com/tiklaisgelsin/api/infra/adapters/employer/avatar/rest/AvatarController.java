package com.tiklaisgelsin.api.infra.adapters.employer.avatar.rest;

import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import com.tiklaisgelsin.api.infra.adapters.employer.avatar.rest.dto.AvatarUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/avatar/")
public class AvatarController {

    private final UseCaseHandler<Void, UpdateEmployerAvatar> handler;

    @PatchMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployerAvatar(@RequestBody AvatarUpdateRequest avatarUpdateRequest) {
        handler.handle(avatarUpdateRequest.toUseCase());
    }
}

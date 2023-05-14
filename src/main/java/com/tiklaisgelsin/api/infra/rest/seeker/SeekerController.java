package com.tiklaisgelsin.api.infra.rest.seeker;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.seeker.usecase.avatar.UpdateSeekerAvatar;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerCreate;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerGet;
import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import com.tiklaisgelsin.api.infra.rest.seeker.dto.seeker.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seeker/")
public class SeekerController {

    private final SeekerJpaRepository repository;
    private final UseCaseHandler<Seeker, SeekerGet> getHandler;
    private final UseCaseHandler<Seeker, SeekerCreate> createHandler;
    private final VoidUseCaseHandler<SeekerUpdate> updateHandler;
    private final VoidUseCaseHandler<UpdateSeekerAvatar> updateAvatarHandler;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeekerForVisitResponse getSeekerForVisit(@PathVariable Long id) {
        return SeekerForVisitResponse.fromModel(getHandler.handle(
                SeekerGet.builder()
                        .seekerId(id)
                        .build()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeekerForVisitResponse createSeeker(@Validated @RequestBody SeekerCreateRequest request) {
        return SeekerForVisitResponse.fromModel(
                createHandler.handle(request.toUseCase()));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateSeeker(@Validated @RequestBody SeekerUpdateRequest request) {
        updateHandler.handle(request.toUseCase());
    }

    @PatchMapping("avatar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSeekerAvatar(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
        String base64 = Base64.getEncoder().encodeToString(file.getBytes());
        updateAvatarHandler.handle(UpdateSeekerAvatar.builder()
                .seekerId(id)
                .avatar(base64)
                .build());
    }

    @PostMapping("login")
    public ResponseEntity<?> loginForSeeker(@Validated @RequestBody SeekerLoginRequest request) {
        Optional<SeekerEntity> seeker = repository
                .findByEmailAndPassword(request.getEmail(), request.getPassword());

        if (seeker.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("The email or password is incorrect.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(seeker.get().getId());
    }

    @GetMapping("me/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeekerResponse getSeeker(@PathVariable Long id) {
        return SeekerResponse.fromModel(getHandler.handle(
                SeekerGet.builder()
                        .seekerId(id)
                        .build()));
    }

}

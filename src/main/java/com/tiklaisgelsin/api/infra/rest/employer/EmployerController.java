package com.tiklaisgelsin.api.infra.rest.employer;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.usecase.avatar.UpdateEmployerAvatar;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerCreate;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerGet;
import com.tiklaisgelsin.api.domain.employer.usecase.employer.EmployerUpdate;
import com.tiklaisgelsin.api.infra.jpa.entity.EmployerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EmployerJpaRepository;
import com.tiklaisgelsin.api.infra.rest.employer.dto.employer.EmployerCreateRequest;
import com.tiklaisgelsin.api.infra.rest.employer.dto.employer.EmployerForVisitResponse;
import com.tiklaisgelsin.api.infra.rest.employer.dto.employer.EmployerLoginRequest;
import com.tiklaisgelsin.api.infra.rest.employer.dto.employer.EmployerUpdateRequest;
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
@RequestMapping("/employer/")
public class EmployerController {

    private final EmployerJpaRepository repository;
    private final UseCaseHandler<Employer, EmployerGet> getUseCaseHandler;
    private final UseCaseHandler<Employer, EmployerCreate> createUseCaseHandler;
    private final VoidUseCaseHandler<EmployerUpdate> updateUseCaseHandler;
    private final VoidUseCaseHandler<UpdateEmployerAvatar> updateEmployerAvatarVoidUseCaseHandler;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployerForVisitResponse getEmployerForVisit(@PathVariable Long id) {
        return EmployerForVisitResponse.fromModel(
                getUseCaseHandler.handle(
                        EmployerGet.builder()
                                .employerId(id)
                                .build()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployerForVisitResponse createEmployer(@Validated @RequestBody EmployerCreateRequest request) {
        return EmployerForVisitResponse.fromModel(
                createUseCaseHandler.handle(
                        EmployerCreate.builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .password(request.getPassword())
                                .build()));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployer(@Validated @RequestBody EmployerUpdateRequest request) {
        updateUseCaseHandler.handle(
                EmployerUpdate.builder()
                        .employerId(request.getId())
                        .name(request.getName())
                        .description(request.getDescription())
                        .email(request.getEmail())
                        .webSite(request.getWebSite())
                        .scale(request.getScale())
                        .build());
    }

    @PatchMapping("avatar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployerAvatar(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
        String base64 = Base64.getEncoder().encodeToString(file.getBytes());
        updateEmployerAvatarVoidUseCaseHandler.handle(UpdateEmployerAvatar.builder()
                .employerId(id)
                .avatar(base64)
                .build());
    }

    @PostMapping("login")
    public ResponseEntity<?> loginForEmployer(@Validated @RequestBody EmployerLoginRequest request) {
        Optional<EmployerEntity> employer = repository
                .findByEmailAndPassword(request.getEmail(), request.getPassword());

        if (employer.isEmpty()) return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("The email or password is incorrect.");

        return ResponseEntity.status(HttpStatus.OK).body(employer.get().getId());
    }
}

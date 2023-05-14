package com.tiklaisgelsin.api.infra.rest.seeker.dto.seeker;

import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerCreate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeekerCreateRequest {

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String surname;

    @NotNull
    private LocalDate birth;

    public SeekerCreate toUseCase() {
        return SeekerCreate.builder()
                .email(email)
                .password(password)
                .name(name)
                .surname(surname)
                .birth(birth)
                .build();
    }
}

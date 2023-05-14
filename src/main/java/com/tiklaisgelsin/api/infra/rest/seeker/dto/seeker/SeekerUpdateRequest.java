package com.tiklaisgelsin.api.infra.rest.seeker.dto.seeker;

import com.tiklaisgelsin.api.domain.seeker.usecase.seeker.SeekerUpdate;
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
public class SeekerUpdateRequest {

    @NotNull
    private Long id;
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String surname;

    private String biography;

    @NotNull
    private LocalDate birth;

    public SeekerUpdate toUseCase() {
        return SeekerUpdate.builder()
                .seekerId(id)
                .email(email)
                .name(name)
                .surname(surname)
                .biography(biography)
                .birth(birth)
                .build();
    }
}

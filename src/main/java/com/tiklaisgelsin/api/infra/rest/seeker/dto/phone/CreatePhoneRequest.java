package com.tiklaisgelsin.api.infra.rest.seeker.dto.phone;

import com.tiklaisgelsin.api.domain.seeker.usecase.phone.AddSeekerPhone;
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
public class CreatePhoneRequest {

    @NotNull
    private Long seekerId;

    @NotNull
    @NotBlank
    private String prefix;

    @NotNull
    @NotBlank
    private String number;

    public AddSeekerPhone toUseCase() {
        return AddSeekerPhone.builder()
                .seekerId(seekerId)
                .prefix(prefix)
                .number(number)
                .build();
    }

}

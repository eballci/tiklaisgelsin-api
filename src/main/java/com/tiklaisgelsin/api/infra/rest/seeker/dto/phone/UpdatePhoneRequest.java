package com.tiklaisgelsin.api.infra.rest.seeker.dto.phone;

import com.tiklaisgelsin.api.domain.seeker.usecase.phone.UpdateSeekerPhone;
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
public class UpdatePhoneRequest {

    @NotNull
    private Long phoneId;

    @NotNull
    @NotBlank
    private String prefix;

    @NotNull
    @NotBlank
    private String number;

    public UpdateSeekerPhone toUseCase() {
        return UpdateSeekerPhone.builder()
                .phoneId(phoneId)
                .prefix(prefix)
                .number(number)
                .build();
    }

}

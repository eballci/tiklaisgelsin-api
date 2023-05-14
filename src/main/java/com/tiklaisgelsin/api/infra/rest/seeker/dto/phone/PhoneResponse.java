package com.tiklaisgelsin.api.infra.rest.seeker.dto.phone;

import com.tiklaisgelsin.api.domain.common.model.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResponse {
    private Long id;
    private String prefix;
    private String number;

    public static PhoneResponse fromModel(Phone phone) {
        return PhoneResponse.builder()
                .id(phone.getId())
                .prefix(phone.getPrefix())
                .number(phone.getNumber())
                .build();
    }

}

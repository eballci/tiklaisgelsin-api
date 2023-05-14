package com.tiklaisgelsin.api.infra.rest.seeker.dto.seeker;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeekerForVisitResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String avatar;
    private String biography;

    public static SeekerForVisitResponse fromModel(Seeker seeker) {
        return SeekerForVisitResponse.builder()
                .id(seeker.getId())
                .name(seeker.getName())
                .surname(seeker.getSurname())
                .email(seeker.getEmail())
                .avatar(seeker.getAvatar())
                .biography(seeker.getBiography())
                .build();
    }
}

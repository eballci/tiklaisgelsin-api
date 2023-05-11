package com.tiklaisgelsin.api.infra.rest.employer.dto.employer;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForVisitResponse {
    private Long id;
    private String avatar;
    private String name;
    private String description;
    private String webSite;
    private int scale;

    public static EmployerForVisitResponse fromModel(Employer employer) {
        return EmployerForVisitResponse.builder()
                .id(employer.getId())
                .avatar(employer.getAvatar())
                .name(employer.getName())
                .description(employer.getDescription())
                .webSite(employer.getWebSite())
                .scale(employer.getScale())
                .build();
    }
}

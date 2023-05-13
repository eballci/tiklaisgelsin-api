package com.tiklaisgelsin.api.infra.rest.employer.dto.position;

import com.tiklaisgelsin.api.domain.employer.usecase.position.CreatePosition;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request.CriteriaRequest;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request.CriteriaRequestService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionCreateRequest {

    @NotNull
    private Long employerId;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    private List<CriteriaRequest> criteriaList;

    public CreatePosition toUseCase(CriteriaRequestService service) {
        return CreatePosition.builder()
                .employerId(employerId)
                .criteriaList(Optional.ofNullable(criteriaList)
                        .map(service::getCreateCriteriaUseCaseList)
                        .orElse(new LinkedList<>()))
                .title(title)
                .description(description)
                .build();
    }
}

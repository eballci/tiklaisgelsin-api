package com.tiklaisgelsin.api.infra.rest.employer.dto.position;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response.CriteriaResponse;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response.CriteriaResponseService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionResponse {
    private Long id;
    private Long employerId;
    private String title;
    private String description;
    private Map<String, List<CriteriaResponse>> criteriaList;

    public static PositionResponse fromModel(CriteriaResponseService service, Position position) {
        return PositionResponse.builder()
                .id(position.getId())
                .description(position.getDescription())
                .title(position.getTitle())
                .employerId(position.getEmployerId())
                .criteriaList(service.getCriteriaListResponse(position.getCriteriaList()))
                .build();
    }
}

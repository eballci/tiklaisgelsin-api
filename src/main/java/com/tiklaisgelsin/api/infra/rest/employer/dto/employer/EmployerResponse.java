package com.tiklaisgelsin.api.infra.rest.employer.dto.employer;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import com.tiklaisgelsin.api.infra.rest.common.dto.OfferResponse;
import com.tiklaisgelsin.api.infra.rest.common.dto.SubmissionResponse;
import com.tiklaisgelsin.api.infra.rest.common.dto.SuggestionResponse;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.PositionResponse;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response.CriteriaResponseService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponse {
    private Long id;
    private String avatar;
    private String name;
    private String description;
    private String email;
    private String webSite;
    private int scale;
    private List<PositionResponse> openPositions;
    private List<SubmissionResponse> submissions;
    private List<OfferResponse> offers;
    private SortedSet<SuggestionResponse> suggestions;

    public static EmployerResponse fromModel(CriteriaResponseService service, Employer employer) {
        return EmployerResponse.builder()
                .id(employer.getId())
                .avatar(employer.getAvatar())
                .name(employer.getName())
                .description(employer.getDescription())
                .email(employer.getEmail())
                .webSite(employer.getWebSite())
                .scale(employer.getScale())
                .openPositions(employer.getOpenPositions().stream().map(p -> PositionResponse.fromModel(service, p)).toList())
                .submissions(employer.getSubmissions().stream().map(SubmissionResponse::fromModel).toList())
                .offers(employer.getOffers().stream().map(OfferResponse::fromModel).toList())
                .suggestions(
                        employer.getSeekerSuggestions().stream()
                                .map(SuggestionResponse::fromModel)
                                .collect(Collectors.toCollection(TreeSet::new))
                )
                .build();
    }
}

package com.tiklaisgelsin.api.infra.rest.common.dto;

import com.tiklaisgelsin.api.domain.common.model.PositionSuggestion;
import com.tiklaisgelsin.api.domain.common.model.SeekerSuggestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionResponse implements Comparable<SuggestionResponse> {
    private Long id;
    private Long positionId;
    private Long seekerId;
    private int matchRate;

    public static SuggestionResponse fromModel(SeekerSuggestion suggestion) {
        return SuggestionResponse.builder()
                .id(suggestion.getId())
                .positionId(suggestion.getPositionId())
                .seekerId(suggestion.getSeekerId())
                .matchRate(suggestion.getMatchRate())
                .build();
    }

    public static SuggestionResponse fromModel(PositionSuggestion suggestion) {
        return SuggestionResponse.builder()
                .id(suggestion.getId())
                .positionId(suggestion.getPositionId())
                .matchRate(suggestion.getMatchRate())
                .build();
    }

    @Override
    public int compareTo(SuggestionResponse o) {
        return -Integer.compare(this.matchRate, o.matchRate);
    }
}

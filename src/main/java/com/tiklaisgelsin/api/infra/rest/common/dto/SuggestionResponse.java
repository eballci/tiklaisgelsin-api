package com.tiklaisgelsin.api.infra.rest.common.dto;

import com.tiklaisgelsin.api.domain.common.model.PositionSuggestion;
import com.tiklaisgelsin.api.domain.common.model.SeekerSuggestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionResponse implements Comparable<SuggestionResponse> {
    private Long id;
    private Long positionId;
    private Long seekerId;
    private int matchRate;
    private LocalDateTime createdAt;

    public static SuggestionResponse fromModel(SeekerSuggestion suggestion) {
        return SuggestionResponse.builder()
                .id(suggestion.getId())
                .positionId(suggestion.getPositionId())
                .seekerId(suggestion.getSeekerId())
                .matchRate(suggestion.getMatchRate())
                .createdAt(suggestion.getCreatedAt())
                .build();
    }

    public static SuggestionResponse fromModel(PositionSuggestion suggestion) {
        return SuggestionResponse.builder()
                .id(suggestion.getId())
                .positionId(suggestion.getPositionId())
                .matchRate(suggestion.getMatchRate())
                .createdAt(suggestion.getCreatedAt())
                .build();
    }

    @Override
    public int compareTo(SuggestionResponse o) {
        if (-Integer.compare(this.matchRate, o.matchRate) != 0)
            return -Integer.compare(this.matchRate, o.matchRate);
        return -createdAt.compareTo(o.createdAt);
    }
}

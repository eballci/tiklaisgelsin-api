package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PositionSuggestion implements Comparable<PositionSuggestion> {
    private Long id;
    private int matchRate;
    private Long positionId;
    private LocalDateTime createdAt;

    @Override
    public int compareTo(PositionSuggestion o) {
        if (-Integer.compare(this.matchRate, o.matchRate) != 0)
            return -Integer.compare(this.matchRate, o.matchRate);
        return -createdAt.compareTo(o.createdAt);
    }
}

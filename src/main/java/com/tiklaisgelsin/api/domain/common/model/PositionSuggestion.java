package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PositionSuggestion implements Comparable<PositionSuggestion> {
    private Long id;
    private int matchRate;
    private Position position;
    private LocalDateTime createdAt;

    @Override
    public int compareTo(PositionSuggestion o) {
        return -Integer.compare(this.matchRate, o.matchRate);
    }
}
